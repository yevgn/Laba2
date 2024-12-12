package ru.anastasia.laba2.screens.carinfo.presenter

import ru.anastasia.laba2.entity.Car

interface Presenter {
    fun loadInfo()

    fun onEditButtonClick()

    fun getInfo(): Car
}