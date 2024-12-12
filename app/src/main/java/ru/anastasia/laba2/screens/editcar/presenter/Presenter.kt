package ru.anastasia.laba2.screens.editcar.presenter

import ru.anastasia.laba2.entity.Car

interface Presenter {
    fun onSaveButtonClick(b: Car)
    fun loadInfo()
    fun getInfo(): Car
}