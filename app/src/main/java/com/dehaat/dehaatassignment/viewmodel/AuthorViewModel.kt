package com.dehaat.dehaatassignment.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dehaat.dehaatassignment.datalayer.model.Author
import com.dehaat.dehaatassignment.datalayer.model.AuthorResponse
import com.dehaat.dehaatassignment.datalayer.repository.AuthorRepository
import com.dehaat.dehaatassignment.datalayer.rest.Resource
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AuthorViewModel @Inject constructor(private val repository: AuthorRepository) : ViewModel() {

    val authorsLiveData: MutableLiveData<Resource<List<Author>?>> by lazy { MutableLiveData<Resource<List<Author>?>>() }

    fun getAuthorsList() {
        authorsLiveData.postValue(Resource.loading(null))
        CoroutineScope(Dispatchers.Main).launch {
            try {

                repository.fetchDataFromApi().enqueue(object : Callback<AuthorResponse> {
                    override fun onResponse(call: Call<AuthorResponse>, response: Response<AuthorResponse>) {
                        if (response?.body()?.authors != null && response.body()?.authors!!.isNotEmpty()) {
                            authorsLiveData.postValue(Resource.success(data = response?.body()?.authors))
                        } else {
                            authorsLiveData.postValue(Resource.error(data = null, message = "No Authors found!!"))
                        }
                    }

                    override fun onFailure(call: Call<AuthorResponse>, t: Throwable) {
                        Log.d("DD::", "onFailure")
                    }
                })
            } catch (cancellationException: CancellationException) {
                authorsLiveData.postValue(Resource.error(data = null, message = "Request Cancelled"))
            } catch (e: Exception) {
                Resource.error(data = null, message = e.message ?: "No Authors found!!")
            }

        }
    }
}
