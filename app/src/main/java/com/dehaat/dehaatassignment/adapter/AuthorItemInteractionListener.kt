package com.dehaat.dehaatassignment.adapter

import com.dehaat.dehaatassignment.datalayer.model.Author

interface AuthorItemInteractionListener {
    fun onAuthorSelected(author: Author, poistion: Int)
}