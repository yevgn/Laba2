package ru.anastasia.laba2.screens.bookinfo.presenter

import androidx.lifecycle.LifecycleOwner
import ru.anastasia.laba2.R
import ru.anastasia.laba2.constant.MAIN
import ru.anastasia.laba2.screens.bookinfo.view.View
import ru.anastasia.laba2.datamodel.DataModel
import ru.anastasia.laba2.entity.Book

class PresenterImpl(
    private val view: View?,
    private val dataModel: DataModel
) : Presenter {

    private lateinit var book : Book

    override fun loadInfo() {
        dataModel.dataForBookInfo.observe(view?.getViewLifecycleOwner() as LifecycleOwner) {
            it?.let {
                book = it
                view.showInfo(it)
            }
        }
    }

    override fun onEditButtonClick() {
        dataModel.dataForEditBookInfo.value = getInfo().copy()
        MAIN.navController.navigate(R.id.action_bookInfo_to_editBookInfo)
    }

    override fun getInfo(): Book = book
}