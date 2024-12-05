package ru.antonov.laba2.screens.main.presenter

import android.view.MenuItem
import ru.antonov.laba2.R
import ru.antonov.laba2.model.Model
import ru.antonov.laba2.screens.main.view.View


class PresenterImpl(
    private val view: View?,
    private val model: Model
): Presenter {

    override fun onBottomNavigationViewClick(item : MenuItem) {
        if (item.itemId == R.id.home_page_item) {
            view?.navigateToBookList()
        }
    }

    override fun onBackButtonClick() {
        view?.popBack()
    }
}