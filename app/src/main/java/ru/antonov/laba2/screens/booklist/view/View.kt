package ru.antonov.laba2.screens.booklist.view

import ru.antonov.laba2.entity.Book


interface View {
    fun showBooks(bookList: MutableList<Book>)
}