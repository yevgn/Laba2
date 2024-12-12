package ru.anastasia.laba2.screens.bookinfo.presenter

import ru.anastasia.laba2.entity.Book

interface Presenter {
    fun loadInfo()

    fun onEditButtonClick()

    fun getInfo(): Book
}