package ru.antonov.laba2.screens.addbook.presenter



import ru.antonov.laba2.screens.addbook.view.View
import ru.antonov.laba2.entity.Book
import ru.antonov.laba2.model.Model

class PresenterImpl(
    private val view: View?,
    private val model: Model
) : Presenter {
    override fun onSaveButtonClick(b: Book) {
        model.postBook(b)
        view?.navigateToBookList()
    }
}