package com.dehaat.dehaatassignment.dagger.builder

import com.dehaat.dehaatassignment.datalayer.repository.AuthorRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBuilder {
    @Binds
    abstract fun bindsMovieRepository(repoImp: AuthorRepository): AuthorRepository
}