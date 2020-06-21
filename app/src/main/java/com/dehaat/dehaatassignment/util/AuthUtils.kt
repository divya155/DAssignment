package com.dehaat.dehaatassignment.util

object AuthUtils {

    val emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})\$"
    val passwordRegex = "^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})"

    fun isUserLoggedIn(): Boolean{
        return false
    }
    fun isSessionValid(): Boolean{
        return false
    }

    fun refreshSession(){}
}