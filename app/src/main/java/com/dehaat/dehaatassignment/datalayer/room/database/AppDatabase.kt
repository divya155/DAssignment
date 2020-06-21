package com.dehaat.dehaatassignment.datalayer.room.database

import androidx.room.Database
import androidx.room.RoomDatabase

import com.dehaat.dehaatassignment.datalayer.room.dao.AuthorDao
import com.dehaat.dehaatassignment.datalayer.model.Author

@Database(entities = [Author::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun authorDao(): AuthorDao

    companion object {
        const val NAME = "author_database"
        const val VERSION = 1
    }

}
