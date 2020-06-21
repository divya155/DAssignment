package com.dehaat.dehaatassignment.datalayer.room

import com.dehaat.dehaatassignment.datalayer.model.Author
import com.dehaat.dehaatassignment.datalayer.room.dao.AuthorDao
import javax.inject.Inject

class DbHelper  @Inject constructor(var authorDao: AuthorDao) {

    fun getAuthors() = authorDao.getAuthors()
    fun saveAuthors(authors: List<Author>){
        authorDao.deleteAll()
        authorDao.insert(authors)
    }


}