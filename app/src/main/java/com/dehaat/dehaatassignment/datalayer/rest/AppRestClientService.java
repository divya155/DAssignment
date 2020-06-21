package com.dehaat.dehaatassignment.datalayer.rest;

import com.dehaat.dehaatassignment.datalayer.model.Author;
import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AppRestClientService {

    @POST("login")
    Call<JsonElement> login();

    @GET("authors")
    Call<JsonElement> getListOfAuthors();

}
