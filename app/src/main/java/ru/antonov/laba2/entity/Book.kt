package ru.antonov.laba2.entity

import java.util.concurrent.atomic.AtomicInteger

data class Book(var name: String, var author: String, var year: Int,
            var genre: String) {

    var id: Int = count.incrementAndGet()

    companion object{
        private val count: AtomicInteger = AtomicInteger(0)
    }
}