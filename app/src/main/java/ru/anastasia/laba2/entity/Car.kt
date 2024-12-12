package ru.anastasia.laba2.entity

import java.util.concurrent.atomic.AtomicInteger

data class Car(var name: String, var engineVolume: Float, var speed: Float,
               var year: Int) {

    var id: Int = count.incrementAndGet()

    companion object{
        private val count: AtomicInteger = AtomicInteger(0)
    }
}