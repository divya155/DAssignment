package com.dehaat.dehaatassignment.datalayer.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
data class Author(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val id: Int,

        @ColumnInfo(name = "author_name")
        val author_name: String? = null,

        @ColumnInfo(name = "author_bio")
        val author_bio: String? = null

) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString(),
                parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeInt(id)
                parcel.writeString(author_name)
                parcel.writeString(author_bio)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Author> {
                override fun createFromParcel(parcel: Parcel): Author {
                        return Author(parcel)
                }

                override fun newArray(size: Int): Array<Author?> {
                        return arrayOfNulls(size)
                }
        }
}