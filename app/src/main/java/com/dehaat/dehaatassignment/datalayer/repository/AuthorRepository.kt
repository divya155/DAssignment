package com.dehaat.dehaatassignment.datalayer.repository

import android.app.Application
import com.dehaat.dehaatassignment.datalayer.room.DbHelper
import com.dehaat.dehaatassignment.datalayer.rest.ApiHelper
import javax.inject.Inject

class AuthorRepository @Inject constructor(val application: Application, val apiHelper: ApiHelper, val dbHelper: DbHelper){

}