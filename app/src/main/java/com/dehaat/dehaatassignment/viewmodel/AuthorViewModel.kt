package com.dehaat.dehaatassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dehaat.dehaatassignment.datalayer.model.Author
import com.dehaat.dehaatassignment.datalayer.repository.AuthorRepository
import com.dehaat.dehaatassignment.datalayer.rest.Resource
import javax.inject.Inject

class AuthorViewModel @Inject constructor(private val repository: AuthorRepository) : ViewModel() {

    private val selectedAuthorLiveData = MutableLiveData<Author>()

    fun getAuthorsList(): LiveData<Resource<List<Author>?>> {
        return repository.getAuthorsList()
    }

    fun onAuthorSelected(author: Author){
        selectedAuthorLiveData.postValue(author)
    }

    fun getSelectedAuthoreViewModel(): LiveData<Author>{
        return selectedAuthorLiveData
    }
}
