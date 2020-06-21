package com.dehaat.dehaatassignment.activity


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.dehaat.dehaatassignment.R
import com.dehaat.dehaatassignment.datalayer.model.Author
import com.dehaat.dehaatassignment.fragment.AuthorListFrament
import com.dehaat.dehaatassignment.fragment.BookListFragment
import com.dehaat.dehaatassignment.fragment.FragmentFactory


class MainActivity : BaseActivity(), AuthorListFrament.AuthorItemInteractionListener{
    override fun onAuthorSelected(author: Author, poistion: Int) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
                .replace(
                        R.id.authorFragmentContainer,
                        FragmentFactory.getBookListFrament(supportFragmentManager,author),
                        BookListFragment.FRAGMENT_NAME
                )
        fragmentTransaction.addToBackStack(BookListFragment.FRAGMENT_NAME)
        fragmentTransaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val fragmentTransaction = supportFragmentManager.beginTransaction()
                .replace(
                        R.id.authorFragmentContainer,
                        FragmentFactory.getAuthorListFrament(supportFragmentManager),
                        AuthorListFrament.FRAGMENT_NAME
                )
        fragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.app_menu, menu)
        return super.onCreateOptionsMenu(menu)
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

}
