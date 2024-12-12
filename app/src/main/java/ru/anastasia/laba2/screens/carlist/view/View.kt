package ru.anastasia.laba2.screens.carlist.view

import ru.anastasia.laba2.entity.Car


interface View {
    fun showCars(carList: MutableList<Car>)
}