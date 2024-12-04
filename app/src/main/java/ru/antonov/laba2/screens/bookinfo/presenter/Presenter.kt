package ru.antonov.laba2.screens.bookinfo.presenter

import ru.antonov.laba2.entity.Book

interface Presenter {
    fun loadInfo()

    fun onEditButtonClick(b: Book)

    fun getInfo(): Book
}