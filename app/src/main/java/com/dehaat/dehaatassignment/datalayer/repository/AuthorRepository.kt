package com.dehaat.dehaatassignment.datalayer.repository

import android.app.Application
import android.util.Log
import com.dehaat.dehaatassignment.datalayer.model.Author
import com.dehaat.dehaatassignment.datalayer.model.AuthorResponse
import com.dehaat.dehaatassignment.datalayer.rest.ApiHelper
import com.dehaat.dehaatassignment.datalayer.room.DbHelper
import com.dehaat.dehaatassignment.util.AuthUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AuthorRepository @Inject constructor(val application: Application, val apiHelper: ApiHelper, val dbHelper: DbHelper) {


//    suspend fun getAuthors(): AuthorResponse? {
//        if (AuthUtils.isNetworkConnected(application)) {
//            return fetchDataFromApi()
//        } else {
//            return fecthDataFromDB()
//        }
//    }

//    fun fecthDataFromDB(): AuthorResponse? {
//        val authors = dbHelper.getAuthors()
//        return formatResponse(authors)
//    }

    private fun formatResponse(authors: List<Author>?): AuthorResponse? {
       return AuthorResponse(
                authors,
                "ok",
                if (authors != null && authors.size > 0) {
                    "error"
                } else {
                    "No Results found"
                }
        )
    }

    fun fetchDataFromApi(): Call<AuthorResponse> {
        return apiHelper.getAuthors()
    }
}