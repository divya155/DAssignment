package com.dehaat.dehaatassignment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dehaat.dehaatassignment.R
import com.dehaat.dehaatassignment.adapter.BookAdapter
import com.dehaat.dehaatassignment.datalayer.model.Author
import dagger.android.support.DaggerFragment

/**
 * A fragment representing a list of Items.
 *
 *
 * Activities containing this fragment MUST implement the [OnListFragmentInteractionListener]
 * interface.
 */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class BookListFragment : DaggerFragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.run { inflate(R.layout.author_list_frament_fragment, container, false) }

        val author = arguments?.getParcelable<Author>("data")
        this.recyclerView = view.findViewById<RecyclerView>(R.id.list);
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?
            adapter = BookAdapter(context)
        }

        (recyclerView.adapter as BookAdapter).setmValues(author?.books)
        return view
    }

    companion object {
        val FRAGMENT_NAME: String = "BookListFragment"

    }

}
