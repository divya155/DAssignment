package com.dehaat.dehaatassignment.datalayer.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val id: Int,

        @ColumnInfo(name = "title")
        var title: String? = null,

        @ColumnInfo(name = "description")
        var description: String? = null,

        @ColumnInfo(name = "publisher")
        var publisher: String? = null,

        @ColumnInfo(name = "published_date")
        var published_date: String? = null,

        @ColumnInfo(name = "price")
        var price: Float? = null
)
