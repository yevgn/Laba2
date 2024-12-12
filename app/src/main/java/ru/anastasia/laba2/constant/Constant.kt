package ru.anastasia.laba2.constant

import ru.anastasia.laba2.entity.Car
import ru.anastasia.laba2.screens.main.view.MainActivity

// Ленивая инициализация
lateinit var MAIN: MainActivity

val carList : MutableList<Car> = mutableListOf(
    Car("AUDIX1", 123.5f, 200.0f, 2000),
    Car( "AUDIX2", 123.5f, 200.0f, 2000),
    Car( "AUDIX3",123.5f, 200.0f, 2000),
    Car( "AUDIX4", 123.5f, 200.0f, 2000),
    Car( "AUDIX5",123.5f,  200.0f, 2000),
    Car( "AUDIX6", 123.5f,  200.0f,2000),
    Car( "Жигуль",123.5f,  200.0f, 2000),
    Car("Запорожец", 123.5f,  200.0f, 2000),
    Car( "Toyota Camri A1", 123.5f,  200.0f, 2000),
    Car("Toyota Camri A2",123.5f,  200.0f, 2000),
    Car( "Toyota Camri A3", 123.5f,  200.0f,2000),
    Car( "Toyota Camri A4", 123.5f,  200.0f, 2000),
    Car( "Toyota Camri A5", 123.5f,  200.0f, 2000),
    Car( "Семерка", 123.5f,  200.0f, 2000),
    Car( "Toyota Camri A6", 123.5f,  200.0f, 2000),
    Car( "Шестерка", 123.5f,  200.0f, 2000),
    Car( "Москвич",123.5f,  200.0f, 2000),
    Car( "Нива", 123.5f,  200.0f,2000),
    Car( "Черная молния", 123.5f,  200.0f, 2000),
    Car( "Бэтмобиль",123.5f, 500.0f, 2000)
)
