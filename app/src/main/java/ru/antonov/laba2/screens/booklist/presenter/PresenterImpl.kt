package ru.antonov.laba2.screens.booklist.presenter

import ru.antonov.laba2.constant.bookList
import ru.antonov.laba2.screens.booklist.view.View
import ru.antonov.laba2.datamodel.DataModel
import ru.antonov.laba2.entity.Book
import ru.antonov.laba2.model.Model

class PresenterImpl(
    private val view: View?,
    private val model: Model,
    private val dataModel: DataModel): Presenter {

    override fun onDeleteButtonClick(b: Book) {
        model.deleteBook(b)
        loadDataFromModel()
    }

    override fun onAddButtonClick() {
        view?.navigateToAddBook()
    }

    override fun onItemClick(b: Book) {
        dataModel.dataForBookInfo.value = b
        view?.navigateToInfo()
    }

    override fun loadDataFromModel() {
        view?.showBooks(bookList)
    }


}