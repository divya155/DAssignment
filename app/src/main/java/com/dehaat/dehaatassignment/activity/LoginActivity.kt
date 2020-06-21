package com.dehaat.dehaatassignment.activity


import android.os.Bundle
import android.view.View
import android.widget.EditText

import com.dehaat.dehaatassignment.R
import com.dehaat.dehaatassignment.util.AuthUtils

import java.util.regex.Pattern

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<View>(R.id.btn_login).setOnClickListener {

            val etEmail = findViewById<EditText>(R.id.et_email)
            val etPassword = findViewById<EditText>(R.id.et_password)

            var isError: Boolean = false

            isError =  !validateEmail(etEmail)
            isError =  (!validatePassword(etPassword)) || isError

            if(isError){
                return@setOnClickListener
            }

            AuthUtils.setLoggedInPreference(applicationContext,true);
            launchActivity(MainActivity::class.java)
            finish()
        }
    }

    private fun validatePassword(etPassword: EditText): Boolean {
        val pattern = Pattern.compile(AuthUtils.passwordRegex)
        val isMatch = pattern.matcher(etPassword.text.toString()).find()
        if(!isMatch) {
            etPassword.error = "Password must be eight characters or longer and should contain at least\n1 lowercase alphabetical character\n1 uppercase alphabetical character\n1 numeric character\n1 special char {! @ # $ % ^ & *}"
        }
        return isMatch
    }

    private fun validateEmail(etEmail: EditText): Boolean {
        val pattern = Pattern.compile(AuthUtils.emailRegex)
        val isMatch = pattern.matcher(etEmail.text.toString()).find()
        if(!isMatch) {
            etEmail.error = "Please enter a valid email"
        }
        return isMatch
    }
}
