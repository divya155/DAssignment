package com.dehaat.dehaatassignment.dagger.builder

import com.dehaat.dehaatassignment.fragment.AuthorListFrament
import com.dehaat.dehaatassignment.fragment.BookListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityProviders{
    @ContributesAndroidInjector
    abstract fun provideAuthorListFrament(): AuthorListFrament

    @ContributesAndroidInjector
    abstract fun provideBookListFragment(): BookListFragment

}