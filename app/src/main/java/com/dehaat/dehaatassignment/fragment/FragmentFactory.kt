package com.dehaat.dehaatassignment.fragment

import android.os.Bundle
import com.dehaat.dehaatassignment.datalayer.model.Author

object FragmentFactory {

    fun getAuthorListFrament(supportFragmentManager: androidx.fragment.app.FragmentManager): AuthorListFrament {
        var fragment = supportFragmentManager.findFragmentByTag(AuthorListFrament.FRAGMENT_NAME)
        if (fragment == null) {
            fragment = AuthorListFrament()
        }
        return fragment as AuthorListFrament
    }

    fun getBookListFrament(supportFragmentManager: androidx.fragment.app.FragmentManager,author: Author): BookListFragment {
        var fragment = supportFragmentManager.findFragmentByTag(BookListFragment.FRAGMENT_NAME)
        if (fragment == null) {
            fragment = BookListFragment()
        }
        val bundle = Bundle()
        bundle.putParcelable("data",author);

        fragment.arguments = bundle
        return fragment as BookListFragment
    }

}