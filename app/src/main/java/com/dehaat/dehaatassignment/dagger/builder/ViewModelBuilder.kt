package com.dehaat.dehaatassignment.dagger.builder

import androidx.lifecycle.ViewModelProvider
import com.dehaat.dehaatassignment.viewmodel.ViewModelFactory
import com.divya.newsapp.di.builder.AppViewModelBuilder
import dagger.Binds
import dagger.Module

@Module(includes = [
    (RepositoryBuilder::class),
    (AppViewModelBuilder::class)
])
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}