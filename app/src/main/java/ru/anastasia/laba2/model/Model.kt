package ru.anastasia.laba2.model

import ru.anastasia.laba2.entity.Car

interface Model {
    fun getCar(name: String): Car?

    fun getCar(id: Int): Car?

    fun getAllCars(): MutableList<Car>

    fun postCar(b: Car)

    fun putCar(id: Int, b: Car)

    fun putCar(name: String, b: Car)

    fun deleteCar(id: Int)

    fun deleteCar(name: String)

    fun deleteCar(b: Car)
}