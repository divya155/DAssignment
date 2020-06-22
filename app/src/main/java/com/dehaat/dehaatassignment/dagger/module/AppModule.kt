package com.dehaat.dehaatassignment.dagger.module

import android.app.Application
import android.content.Context
import com.dehaat.dehaatassignment.datalayer.repository.AuthorRepository
import com.dehaat.dehaatassignment.dagger.builder.ViewModelBuilder
import com.dehaat.dehaatassignment.datalayer.room.DbHelper
import com.dehaat.dehaatassignment.datalayer.rest.ApiHelper
import com.dehaat.dehaatassignment.datalayer.rest.AppRestClientService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelBuilder::class])
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application):Context{
        return application
    }


    @Provides
    @Singleton
    fun provideAuthorRepository(application: Context,apiHelper: ApiHelper, dbHelper: DbHelper): AuthorRepository {
        return AuthorRepository(application,apiHelper, dbHelper)
    }

    @Provides
    @Singleton
    fun providesApiHelper(
        apiService: AppRestClientService
    ): ApiHelper {
        return ApiHelper(apiService)
    }
}