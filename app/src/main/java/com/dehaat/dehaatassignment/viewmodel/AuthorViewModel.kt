package com.dehaat.dehaatassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dehaat.dehaatassignment.datalayer.model.Author
import com.dehaat.dehaatassignment.datalayer.repository.AuthorRepository
import com.dehaat.dehaatassignment.datalayer.rest.Resource
import javax.inject.Inject

class AuthorViewModel @Inject constructor(private val repository: AuthorRepository) : ViewModel() {


    fun getAuthorsList(): LiveData<Resource<List<Author>?>> {
        return repository.getAuthorsList()
    }
}
