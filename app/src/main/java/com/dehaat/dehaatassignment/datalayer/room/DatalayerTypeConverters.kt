package com.divya.newsapp.datalayer.room

import android.text.TextUtils
import androidx.room.TypeConverter
import com.dehaat.dehaatassignment.datalayer.model.Book
import com.google.gson.Gson

class DataTypeConverters{
    @TypeConverter
    fun bookTypeToString(source :Book): String{
        return convertToJson(source)
    }

    @TypeConverter
    fun booksToString(items: List<Book>): String? {
        return getStringForObject(items)
    }
    @TypeConverter
    fun stringTypeToSource(sourceStr :String): Book? {
        return getObjectFromString(sourceStr, Book::class.java)
    }

    @TypeConverter
    fun stringToItems(items: String): List<Book>? {
        return if (TextUtils.isEmpty(items)) null else (getObjectFromString(items, Array<Book>::class.java)!!.toList())
    }

    private fun convertToJson(data: Any): String {
        return Gson().toJson(data)
    }

    fun <T> getObjectFromString(str: String?, clss: Class<T>): T? {
        if (str == null) {
            return null
        }
        var t: T? = null
        try {
            t = Gson().fromJson(str, clss)
        } catch (e: Exception) {
            // nothing to do here
            e.printStackTrace()
        }

        return t
    }

    fun getStringForObject(obj: Any?): String? {
        if (obj == null) {
            return null
        }
        return Gson().toJson(obj)
    }
}