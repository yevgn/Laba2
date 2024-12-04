package ru.antonov.laba2.screens.booklist.presenter

import ru.antonov.laba2.entity.Book

interface Presenter {
    fun onDeleteButtonClick(b: Book)

    fun onItemClick(b: Book)

    fun onAddButtonClick()

    fun loadDataFromModel()
}