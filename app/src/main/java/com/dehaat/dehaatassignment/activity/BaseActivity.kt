package com.dehaat.dehaatassignment.activity


import android.content.Intent
import android.os.Bundle

import com.dehaat.dehaatassignment.R
import com.dehaat.dehaatassignment.util.AuthUtils

import dagger.android.support.DaggerAppCompatActivity

open class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    protected fun launchActivity(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
    }

    protected fun logout() {
        AuthUtils.setLoggedInPreference(applicationContext, false)
        launchActivity(LoginActivity::class.java)
        finish()
    }
}
