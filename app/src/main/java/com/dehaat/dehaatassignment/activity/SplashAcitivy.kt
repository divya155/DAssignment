package com.dehaat.dehaatassignment.activity

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View

import com.dehaat.dehaatassignment.R
import com.dehaat.dehaatassignment.datalayer.model.Author
import com.dehaat.dehaatassignment.datalayer.model.AuthorResponse
import com.dehaat.dehaatassignment.datalayer.rest.ApiHelper
import com.dehaat.dehaatassignment.util.AuthUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import javax.inject.Inject

import kotlin.coroutines.Continuation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashAcitivy : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_acitivy)

        CoroutineScope(Dispatchers.Main).launch {
            startApplication()
        }

    }

    private suspend fun startApplication() {
        delay(1500);
        if (AuthUtils.isUserLoggedIn(applicationContext)) {
            AuthUtils.refreshSession()
            launchActivity(MainActivity::class.java)
        } else {
            launchActivity(LoginActivity::class.java)
        }
        finish()
    }

}
