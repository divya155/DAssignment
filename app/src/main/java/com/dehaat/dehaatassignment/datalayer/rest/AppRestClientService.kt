package com.dehaat.dehaatassignment.datalayer.rest

import com.dehaat.dehaatassignment.datalayer.model.AuthorResponse
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface AppRestClientService {


    @GET("get_authors.json")
    fun authors(): Call<AuthorResponse>

    @GET("get_authors.json")
    fun authorList(): AuthorResponse

    @POST("login")
    fun login(): Call<JsonElement>

}
