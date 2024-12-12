package ru.anastasia.laba2.screens.addbook.presenter

import ru.anastasia.laba2.entity.Book

interface Presenter {
    fun onSaveButtonClick(b: Book)
}