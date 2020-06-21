package com.divya.newsapp.di.builder

import androidx.lifecycle.ViewModel
import com.dehaat.dehaatassignment.viewmodel.AuthorViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(AuthorViewModel::class)
    abstract fun bindAuthorViewModel(homeViewModel: AuthorViewModel): ViewModel
}