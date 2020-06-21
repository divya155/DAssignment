package com.dehaat.dehaatassignment.datalayer.rest

import com.dehaat.dehaatassignment.datalayer.model.AuthorResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Inject


class ApiHelper @Inject constructor(private val apiService: AppRestClientService) {

    fun getAuthors() : Call<AuthorResponse>{
        return  apiService.authors()
    }

}