package com.dehaat.dehaatassignment.datalayer.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dehaat.dehaatassignment.datalayer.model.Author

@Dao
interface AuthorDao{

    @Query("SELECT * FROM authors")
    fun getAuthors(): List<Author>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(articles: List<Author>)

    @Query("DELETE FROM authors")
    fun deleteAll()
}
