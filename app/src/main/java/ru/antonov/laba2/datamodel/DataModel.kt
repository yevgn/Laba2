package ru.antonov.laba2.datamodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.antonov.laba2.entity.Book

class DataModel : ViewModel() {

    val dataForBookInfo: MutableLiveData<Book> by lazy {
        MutableLiveData<Book>()
    }

    val dataForEditBookInfo: MutableLiveData<Book> by lazy{
        MutableLiveData<Book>()
    }

}