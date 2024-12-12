package ru.anastasia.laba2.screens.addcar.presenter

import ru.anastasia.laba2.entity.Car

interface Presenter {
    fun onSaveButtonClick(b: Car)
}