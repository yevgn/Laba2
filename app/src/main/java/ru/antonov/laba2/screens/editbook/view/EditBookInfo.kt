package ru.antonov.laba2.screens.editbook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import ru.antonov.laba2.constant.MAIN
import ru.antonov.laba2.R
import ru.antonov.laba2.entity.Book
import ru.antonov.laba2.databinding.FragmentEditBookInfoBinding
import ru.antonov.laba2.datamodel.DataModel
import ru.antonov.laba2.screens.editbook.presenter.Presenter
import ru.antonov.laba2.screens.editbook.presenter.PresenterImpl
import ru.antonov.laba2.model.ModelImpl


class EditBookInfo : Fragment(), ru.antonov.laba2.screens.editbook.view.View {

    private lateinit var binding: FragmentEditBookInfoBinding
    private val dataModel : DataModel by activityViewModels()
    private lateinit var book: Book
    private var presenter: Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBookInfoBinding.inflate(layoutInflater, container, false)
        presenter = PresenterImpl(this, ModelImpl(), dataModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter?.loadInfo()

        binding.saveDataButton.setOnClickListener {
            val newName = binding.bookNameEt.text.toString()
            val newAuthor = binding.bookAuthorEt.text.toString()
            val newYear  = binding.bookYearEt.text.toString()
            val newGenre   = binding.bookGenreEt.text.toString()

            if(newName.isEmpty() || newAuthor.isEmpty() || newYear.isEmpty()
                || newGenre.isEmpty()) {
                Toast.makeText(
                    context, "Остались незаполненные поля", Toast.LENGTH_SHORT
                ).show()
            } else{
                val newBook = Book(newName,newAuthor, newYear.toInt(), newGenre )
                Toast.makeText(context, "Данные были редактированы", Toast.LENGTH_SHORT).show()
                presenter?.onSaveButtonClick(newBook)
            }
        }
    }

    override fun saveInfo(b: Book) {
        book = b
    }

    override fun getInfo(): Book {
        return book
    }

    override fun navigateToBookList() {
        MAIN.navController.navigate(R.id.action_editBookInfo_to_bookList)
    }
}