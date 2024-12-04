package ru.antonov.laba2.model

import ru.antonov.laba2.entity.Book

interface Model {
    fun getBook(name: String): Book?

    fun getBook(id: Int): Book?

    fun postBook(b: Book)

    fun putBook(id: Int, b: Book)

    fun putBook(name: String, b: Book)

    fun deleteBook(id: Int)

    fun deleteBook(name: String)

    fun deleteBook(b: Book)
}