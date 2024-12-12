package ru.anastasia.laba2.screens.booklist.view

import ru.anastasia.laba2.entity.Book


interface View {
    fun showBooks(bookList: MutableList<Book>)
}