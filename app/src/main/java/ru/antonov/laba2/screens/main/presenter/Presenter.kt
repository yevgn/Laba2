package ru.antonov.laba2.screens.main.presenter

import android.view.MenuItem

interface Presenter {
    fun onBottomNavigationViewClick(item : MenuItem)
    fun onBackButtonClick()
}