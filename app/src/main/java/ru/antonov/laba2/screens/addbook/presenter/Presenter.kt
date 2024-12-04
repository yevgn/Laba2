package ru.antonov.laba2.screens.addbook.presenter

import ru.antonov.laba2.entity.Book

interface Presenter {
    fun onSaveButtonClick(b: Book)
}