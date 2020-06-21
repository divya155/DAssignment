package com.dehaat.dehaatassignment.datalayer.model

import android.os.Parcel
import android.os.Parcelable
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
) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readValue(Float::class.java.classLoader) as? Float) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeInt(id)
                parcel.writeString(title)
                parcel.writeString(description)
                parcel.writeString(publisher)
                parcel.writeString(published_date)
                parcel.writeValue(price)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Book> {
                override fun createFromParcel(parcel: Parcel): Book {
                        return Book(parcel)
                }

                override fun newArray(size: Int): Array<Book?> {
                        return arrayOfNulls(size)
                }
        }
}
