package com.dehaat.dehaatassignment.datalayer.model

import com.google.gson.annotations.SerializedName

data class AuthorResponse(
        @SerializedName("data")
        var authors: List<Author>?,

        @SerializedName("code")
        val code: String,

        @SerializedName("message")
        val message: String?
)