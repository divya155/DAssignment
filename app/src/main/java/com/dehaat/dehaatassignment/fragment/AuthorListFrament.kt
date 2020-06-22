package com.dehaat.dehaatassignment.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dehaat.dehaatassignment.R
import com.dehaat.dehaatassignment.adapter.AuthorAdapter
import com.dehaat.dehaatassignment.adapter.AuthorItemInteractionListener
import com.dehaat.dehaatassignment.datalayer.model.Author
import com.dehaat.dehaatassignment.datalayer.model.Status
import com.dehaat.dehaatassignment.viewmodel.AuthorViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class AuthorListFrament : DaggerFragment(), AuthorItemInteractionListener {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mViewModel: AuthorViewModel

    private lateinit var progressView: View
    private lateinit var recyclerView: RecyclerView
    private lateinit var errorText: TextView

    private lateinit var authorItemInteractionListener: AuthorItemInteractionListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AuthorItemInteractionListener) {
            authorItemInteractionListener = context
        } else {
            throw IllegalStateException("Activity must implement AuthorItemInteractionListener")
        }

        mViewModel = ViewModelProviders.of(activity!!, viewModelFactory).get(AuthorViewModel::class.java)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.run { inflate(R.layout.author_list_frament_fragment, container, false) }


        val listAdapter = AuthorAdapter(context, this)
        this.recyclerView = view.findViewById<RecyclerView>(R.id.list);
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
        errorText = view.findViewById(R.id.errorText)
        progressView = view.findViewById(R.id.progressBar)
        return view
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.getAuthorsList().observe(
                this,
                Observer { resource ->
                    when (resource.status) {
                        Status.LOADING -> {
                            errorText.visibility = View.GONE

                            recyclerView.visibility = View.GONE
                            progressView.visibility = View.VISIBLE
                        }
                        Status.SUCCESS -> {
                            errorText.visibility = View.GONE
                            recyclerView.visibility = View.VISIBLE
                            progressView.visibility = View.GONE
                            resource.data?.let {
                                (recyclerView.adapter as AuthorAdapter).setmValues(it)
                                recyclerView.adapter?.notifyDataSetChanged()
                                mViewModel.onAuthorSelected(it.get(0))
                            }

                        }
                        Status.ERROR -> {
                            errorText.visibility = View.VISIBLE
                            errorText.setText(resource.message)
                            recyclerView.visibility = View.GONE
                            progressView.visibility = View.GONE
                        }
                    }
                }
        )
    }

    override fun onAuthorSelected(author: Author, poistion: Int) {
        mViewModel.onAuthorSelected(author)
        authorItemInteractionListener.onAuthorSelected(author,poistion)
    }

    companion object {

        val FRAGMENT_NAME: String = "AuthorListFragment"

    }


}
