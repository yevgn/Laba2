package ru.anastasia.laba2.screens.addbook.presenter



import ru.anastasia.laba2.R
import ru.anastasia.laba2.constant.MAIN
import ru.anastasia.laba2.screens.addbook.view.View
import ru.anastasia.laba2.entity.Book
import ru.anastasia.laba2.model.Model

class PresenterImpl(
    private val view: View?,
    private val model: Model
) : Presenter {

    override fun onSaveButtonClick(b: Book) {
        model.postBook(b)
        MAIN.navController.navigate(R.id.action_addBook_to_bookList)
    }
}