package ru.anastasia.laba2.screens.booklist.presenter

import ru.anastasia.laba2.R
import ru.anastasia.laba2.constant.MAIN
import ru.anastasia.laba2.screens.booklist.view.View
import ru.anastasia.laba2.datamodel.DataModel
import ru.anastasia.laba2.entity.Book
import ru.anastasia.laba2.model.Model

class PresenterImpl(
    private val view: View?,
    private val model: Model,
    private val dataModel: DataModel): Presenter {

    override fun onDeleteButtonClick(b: Book) {
        model.deleteBook(b)
        loadDataFromModel()
    }

    override fun onAddButtonClick() {
        MAIN.navController.navigate(R.id.action_bookList_to_addBook)
    }

    override fun onItemClick(b: Book) {
        dataModel.dataForBookInfo.value = b
        MAIN.navController.navigate(R.id.action_bookList_to_bookInfo)
    }

    override fun loadDataFromModel() {
        val dataFromModel = model.getAllBooks()
        view?.showBooks(dataFromModel)
    }
}