package com.dehaat.dehaatassignment.datalayer.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "author")
data class Author (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "author_name")
    val author_name: String? = null,

    @ColumnInfo(name = "author_bio")
    val author_bio: String? = null


)
