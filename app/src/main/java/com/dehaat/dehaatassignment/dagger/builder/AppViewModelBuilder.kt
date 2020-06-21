package com.divya.newsapp.di.builder

import androidx.lifecycle.ViewModel
import com.dehaat.dehaatassignment.viewmodel.AuthorListFramentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(AuthorListFramentViewModel::class)
    abstract fun bindAuthorViewModel(homeViewModel: AuthorListFramentViewModel): ViewModel
}