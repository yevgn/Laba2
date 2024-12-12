package ru.anastasia.laba2.screens.carlist.presenter

import ru.anastasia.laba2.entity.Car

interface Presenter {
    fun onDeleteButtonClick(b: Car)

    fun onItemClick(b: Car)

    fun onAddButtonClick()

    fun loadDataFromModel()
}