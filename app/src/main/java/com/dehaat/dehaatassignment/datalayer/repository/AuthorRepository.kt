package com.dehaat.dehaatassignment.datalayer.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dehaat.dehaatassignment.datalayer.model.Author
import com.dehaat.dehaatassignment.datalayer.model.AuthorResponse
import com.dehaat.dehaatassignment.datalayer.rest.ApiHelper
import com.dehaat.dehaatassignment.datalayer.rest.Resource
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


    private val authorsLiveData = MutableLiveData<Resource<List<Author>?>>()

    fun getAuthorsList(): LiveData<Resource<List<Author>?>> {

        if (AuthUtils.isNetworkConnected(application)) {
            fetchApiData()
        } else {
            fecthDataFromDB()
        }
        authorsLiveData.postValue(Resource.loading(data = null))
        return authorsLiveData
    }

    private fun fetchApiData() {
        apiHelper.getAuthors().enqueue(object : Callback<AuthorResponse> {

            override fun onResponse(call: Call<AuthorResponse>, response: Response<AuthorResponse>) {
                if (response.body()?.authors != null && response.body()?.authors!!.isNotEmpty()) {
                    val authors = response.body()?.authors
                    authorsLiveData.postValue(Resource.success(data = authors))
                    saveDataInDB(authors!!)
                } else {
                    authorsLiveData.postValue(Resource.error(data = null, message = "No Authors found!!"))
                }
            }

            override fun onFailure(call: Call<AuthorResponse>, t: Throwable) {
                Resource.error(data = null, message = t.message ?: "No Authors found!!")
            }
        })
    }

    private fun fecthDataFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            val authors = dbHelper.getAuthors()
            if (authors != null && authors.isNotEmpty()) {
                authorsLiveData.postValue(Resource.success(data = authors))
            } else {
                authorsLiveData.postValue(Resource.error(data = null, message = "No Authors found!!"))
            }
        }
    }

    private fun saveDataInDB(authorsList: List<Author>) {
        CoroutineScope(Dispatchers.IO).launch {
            dbHelper.authorDao.deleteAll()
            dbHelper.authorDao.insert(authorsList)
        }
    }

}