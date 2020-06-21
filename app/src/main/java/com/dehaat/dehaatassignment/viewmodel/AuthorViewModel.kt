package com.dehaat.dehaatassignment.viewmodel

import androidx.lifecycle.ViewModel
import com.dehaat.dehaatassignment.datalayer.repository.AuthorRepository
import javax.inject.Inject

class AuthorViewModel @Inject constructor(private val repository: AuthorRepository)  : ViewModel()
