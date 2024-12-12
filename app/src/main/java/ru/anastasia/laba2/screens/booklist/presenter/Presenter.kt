package ru.anastasia.laba2.screens.booklist.presenter

import ru.anastasia.laba2.entity.Book

interface Presenter {
    fun onDeleteButtonClick(b: Book)

    fun onItemClick(b: Book)

    fun onAddButtonClick()

    fun loadDataFromModel()
}