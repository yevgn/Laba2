package ru.anastasia.laba2.screens.editbook.presenter

import androidx.lifecycle.LifecycleOwner
import ru.anastasia.laba2.R
import ru.anastasia.laba2.constant.MAIN
import ru.anastasia.laba2.datamodel.DataModel
import ru.anastasia.laba2.screens.editbook.view.View
import ru.anastasia.laba2.entity.Book
import ru.anastasia.laba2.model.Model

class PresenterImpl(
    private val view: View?,
    private val model: Model,
    private val dataModel: DataModel
) : Presenter {

    private lateinit var book: Book

    override fun onSaveButtonClick(b: Book) {
        model.putBook(getInfo().name, b)
        MAIN.navController.navigate(R.id.action_editBookInfo_to_bookList)
    }

    override fun loadInfo() {
        dataModel.dataForEditBookInfo.observe(view?.getViewLifecycleOwner() as LifecycleOwner) {
            it?.let {
               book = it
            }
        }
    }

    override fun getInfo(): Book = book
}