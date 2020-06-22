package com.dehaat.dehaatassignment.dagger.module

import android.content.Context
import com.dehaat.dehaatassignment.datalayer.rest.AppRestClientService
import com.dehaat.dehaatassignment.datalayer.rest.mock.MockResponseInterceptor
import com.dehaat.dehaatassignment.util.AuthUtils
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {


    @Provides
    @Singleton
    fun providesRetrofit(
            gsonConverterFactory: GsonConverterFactory,
            okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().baseUrl("https://www.dehaat.com/")
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(context: Context): OkHttpClient {
        val cacheSize = (5 * 1024 * 1024).toLong()
        val myCache = Cache(context.cacheDir, cacheSize)
        val client = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .cache(myCache)
        val mock = MockResponseInterceptor(context)
        client.addInterceptor { chain ->
            var request = chain.request()
            request = if (AuthUtils.isNetworkConnected(context)) {
                request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
            }else {
                request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 1).build()
            }
            chain.proceed(chain.request())
        }
        client.addInterceptor(mock)

        return client.build()

    }


    @Provides
    @Singleton
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun providesGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }


    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): AppRestClientService {
        return retrofit.create(AppRestClientService::class.java)
    }
}