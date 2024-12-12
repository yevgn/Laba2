package ru.anastasia.laba2.screens.editbook.presenter

import ru.anastasia.laba2.entity.Book

interface Presenter {
    fun onSaveButtonClick(b: Book)
    fun loadInfo()
    fun getInfo(): Book
}