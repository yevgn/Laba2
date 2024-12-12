package ru.anastasia.laba2.screens.carinfo.view

import androidx.lifecycle.LifecycleOwner
import ru.anastasia.laba2.entity.Car

interface View {
    fun getViewLifecycleOwner(): LifecycleOwner
    fun showInfo(b: Car)
}