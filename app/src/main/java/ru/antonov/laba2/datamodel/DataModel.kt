package ru.antonov.laba2.datamodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.antonov.laba2.entity.Book

class DataModel : ViewModel() {
    // Для передачи данных фрагменту с информ-ей о книге
    val dataForBookInfo: MutableLiveData<Book> by lazy {
        MutableLiveData<Book>()
    }

    // Для передачи данных фрагменту с редактированием информ-ии о книге
    val dataForEditBookInfo: MutableLiveData<Book> by lazy{
        MutableLiveData<Book>()
    }

    // добавить книгу -> список книг
    val dataForBookListFromAddBook : MutableLiveData<Book> by lazy{
        MutableLiveData<Book>()
    }

    // редактировать -> список книг
    val dataForBookListFromEditBookInfo: MutableLiveData<Book> by lazy {
        MutableLiveData<Book>()
    }
}