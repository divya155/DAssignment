package com.dehaat.dehaatassignment.datalayer.room

import com.dehaat.dehaatassignment.datalayer.room.dao.AuthorDao
import javax.inject.Inject

class DbHelper  @Inject constructor(var authorDao: AuthorDao) {
}