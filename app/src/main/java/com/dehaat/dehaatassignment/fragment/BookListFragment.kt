package com.dehaat.dehaatassignment.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dehaat.dehaatassignment.R
import com.dehaat.dehaatassignment.adapter.BookAdapter
import com.dehaat.dehaatassignment.viewmodel.AuthorViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

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

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mViewModel: AuthorViewModel

    private lateinit var recyclerView: RecyclerView


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mViewModel = ViewModelProviders.of(activity!!, viewModelFactory).get(AuthorViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.run { inflate(R.layout.author_list_frament_fragment, container, false) }


        this.recyclerView = view.findViewById<RecyclerView>(R.id.list);
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?
            adapter = BookAdapter(context)
        }

        return view
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.getSelectedAuthoreViewModel().observe(this, Observer {
            val adapter = (recyclerView.adapter as BookAdapter)
            adapter.setmValues(it.books)
            adapter.notifyDataSetChanged()
        })
    }

    companion object {
        val FRAGMENT_NAME: String = "BookListFragment"

    }

}
