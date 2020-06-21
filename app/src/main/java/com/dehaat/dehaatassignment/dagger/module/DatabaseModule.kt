package com.dehaat.dehaatassignment.dagger.module

import android.app.Application
import androidx.room.Room
import com.dehaat.dehaatassignment.datalayer.room.dao.AuthorDao
import com.dehaat.dehaatassignment.datalayer.room.database.AppDatabase
import com.dehaat.dehaatassignment.datalayer.room.DbHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideNewsDatabase(application: Application): AppDatabase{
        return Room.databaseBuilder(
            application,
                AppDatabase::class.java,
                AppDatabase.NAME
        ).build()

    }

    @Provides
    @Singleton
    fun provideArticleDao(appDataBase: AppDatabase): AuthorDao{
        return appDataBase.authorDao()
    }



    @Provides
    @Singleton
    fun providesNewsDbHelper(articleDao: AuthorDao): DbHelper {
        return DbHelper(articleDao)
    }
}