package ru.anastasia.laba2.datamodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.anastasia.laba2.entity.Car

class DataModel : ViewModel() {

    val dataForCarInfo: MutableLiveData<Car> by lazy {
        MutableLiveData<Car>()
    }

    val dataForEditCarInfo: MutableLiveData<Car> by lazy{
        MutableLiveData<Car>()
    }

}