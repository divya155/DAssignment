package com.dehaat.dehaatassignment

import com.dehaat.dehaatassignment.datalayer.model.Author
import com.dehaat.dehaatassignment.datalayer.model.Book

object TestUtil {

    fun createAuthorList(count: Int, author_name: String, author_bio: String): List<Author> {
        val bookList = createBookList(4,"Book Title", "Book description","Publisher",3F)
        return (0 until count).map {
            createAuthor(
                    it,
                    author_name = author_name + it,
                    author_bio = author_bio + it,
                    books = bookList
            )
        }
    }


    fun createAuthor(id: Int, author_name: String, author_bio: String, books: List<Book>) = Author(
            id,
            author_name,
            author_bio,
            books
    )

    private fun createBookList(count: Int, title: String, description: String, publisher: String, price: Float): List<Book> {
        return (0 until count).map {
            createBook(
                    it,
                    title = title + it,
                    description = description + it,
                    publisher = publisher,
                    price = price * 100.0F
            )
        }
    }

    fun createBook(id: Int, title: String, description: String, publisher: String, price: Float) = Book(
            id,
            title,
            description,
            publisher,
            "",
            price
    )

}