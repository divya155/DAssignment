package com.dehaat.dehaatassignment.util

import android.app.Application
import android.content.Context
import javax.inject.Inject

object AuthUtils {

    private val PREF_FILE_NAME = "dehaat_user_pref"
    private val PREF_KEY_LOGGEDIN = "login_status"

    val emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})"
    val passwordRegex = "^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})"

    fun isUserLoggedIn(context: Context): Boolean{
        val sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(PREF_KEY_LOGGEDIN,false)
    }


    fun setLoggedInPreference(context: Context,isLoggedIn: Boolean) {
        val sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean(PREF_KEY_LOGGEDIN,isLoggedIn).commit()
    }

    fun refreshSession(){

    }

}