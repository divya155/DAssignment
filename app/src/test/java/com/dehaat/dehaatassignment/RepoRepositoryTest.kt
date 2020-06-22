package com.dehaat.dehaatassignment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.dehaat.dehaatassignment.datalayer.model.Author
import com.dehaat.dehaatassignment.datalayer.repository.AuthorRepository
import com.dehaat.dehaatassignment.datalayer.rest.ApiHelper
import com.dehaat.dehaatassignment.datalayer.rest.AppRestClientService
import com.dehaat.dehaatassignment.datalayer.rest.Resource
import com.dehaat.dehaatassignment.datalayer.room.DbHelper
import com.dehaat.dehaatassignment.datalayer.room.dao.AuthorDao
import com.dehaat.dehaatassignment.datalayer.room.database.AppDatabase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import org.mockito.ArgumentMatchers
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyList
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.mockito.Mockito.never
import org.mockito.Mockito.reset
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions

@RunWith(JUnit4::class)
class RepoRepositoryTest {
    private lateinit var repository: AuthorRepository
    private val dao = mock(AuthorDao::class.java)
    private val service = mock(AppRestClientService::class.java)
    private val application = mock(DehaatApplication::class.java)
    private val apiHelper = mock(ApiHelper::class.java)
    private val dbHelper = mock(DbHelper::class.java)



    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        val db = mock(AppDatabase::class.java)
        `when`(db.authorDao()).thenReturn(dao)
        `when`(db.runInTransaction(ArgumentMatchers.any())).thenCallRealMethod()
        repository = AuthorRepository(application, apiHelper, dbHelper)
    }

    @Test
    fun loadRepoFromNetwork() {
        val dbData = ArrayList<Author>()
        `when`(dao.getAuthors()).thenReturn(dbData)

        val repo = TestUtil.createAuthorList(5,"Author", "Author Bio")
    }
}