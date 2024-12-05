package ru.antonov.laba2.screens.editbook.view

import androidx.lifecycle.LifecycleOwner
import ru.antonov.laba2.entity.Book

interface View {
    fun getViewLifecycleOwner(): LifecycleOwner
    fun navigateToBookList()
}