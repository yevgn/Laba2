package ru.antonov.laba2.screens.editbook.presenter

import androidx.lifecycle.LifecycleOwner
import ru.antonov.laba2.datamodel.DataModel
import ru.antonov.laba2.screens.editbook.view.View
import ru.antonov.laba2.entity.Book
import ru.antonov.laba2.model.Model

class PresenterImpl(
    private val view: View?,
    private val model: Model,
    private val dataModel: DataModel
) : Presenter {

    private lateinit var book: Book

    override fun onSaveButtonClick(b: Book) {
        model.putBook(getInfo().name, b)
        view?.navigateToBookList()
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