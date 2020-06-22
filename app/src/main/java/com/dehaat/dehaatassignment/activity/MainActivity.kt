package com.dehaat.dehaatassignment.activity


import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.dehaat.dehaatassignment.R
import com.dehaat.dehaatassignment.adapter.AuthorItemInteractionListener
import com.dehaat.dehaatassignment.datalayer.model.Author
import com.dehaat.dehaatassignment.fragment.AuthorListFrament
import com.dehaat.dehaatassignment.fragment.BookListFragment
import com.dehaat.dehaatassignment.fragment.FragmentFactory


class MainActivity : BaseActivity(), AuthorItemInteractionListener {

    private var orientation = Configuration.ORIENTATION_PORTRAIT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            addAuthorListFragment(R.id.authorFragmentContainer)
            addBookListFragment(R.id.bookFragmentContainer)
        } else {
            addAuthorListFragment(R.id.authorFragmentContainer)
        }
    }

    private fun addAuthorListFragment(container: Int) {

        val fragmentTransaction = supportFragmentManager.beginTransaction()
                .replace(
                        container,
                        FragmentFactory.getAuthorListFrament(supportFragmentManager),
                        AuthorListFrament.FRAGMENT_NAME
                )
        fragmentTransaction.commit()

    }

    private fun addBookListFragment(container: Int) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
                .replace(
                        container,
                        FragmentFactory.getBookListFrament(supportFragmentManager),
                        BookListFragment.FRAGMENT_NAME
                )
        fragmentTransaction.addToBackStack(BookListFragment.FRAGMENT_NAME)
        fragmentTransaction.commit()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.app_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d("DD::", "ORIENTATION_LANDSCAPE")
        } else {
            Log.d("DD::", "ORIENTATION_PORTRAIT")
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_logout) {
            logout()
            return true
        }
        if (id == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onAuthorSelected(author: Author, poistion: Int) {
        if(orientation == Configuration.ORIENTATION_PORTRAIT){
            addBookListFragment(R.id.authorFragmentContainer)
        }
    }
}
