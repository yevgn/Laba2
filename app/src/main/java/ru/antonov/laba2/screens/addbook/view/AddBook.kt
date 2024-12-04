package ru.antonov.laba2.screens.addbook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ru.antonov.laba2.entity.Book
import ru.antonov.laba2.constant.MAIN
import ru.antonov.laba2.R
import ru.antonov.laba2.screens.addbook.presenter.Presenter
import ru.antonov.laba2.screens.addbook.presenter.PresenterImpl

import ru.antonov.laba2.databinding.FragmentAddBookBinding
import ru.antonov.laba2.model.ModelImpl

class AddBook : Fragment(), ru.antonov.laba2.screens.addbook.view.View {

    private lateinit var binding : FragmentAddBookBinding
    //private val dataModel : DataModel by activityViewModels()
    private var presenter: Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBookBinding.inflate(layoutInflater, container, false)
        presenter = PresenterImpl(this, ModelImpl())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.saveDataButton.setOnClickListener {
            val name = binding.bookNameEt.text.toString()
            val author = binding.bookAuthorEt.text.toString()
            val year  = binding.bookYearEt.text.toString()
            val genre  = binding.bookGenreEt.text.toString()

            if(name.isEmpty() || author.isEmpty() || year.isEmpty()
                || genre.isEmpty()) {
                Toast.makeText(
                    context, "Остались незаполненные поля", Toast.LENGTH_SHORT
                ).show()
            } else{
                val b = Book(name, author, year.toInt(), genre)
                presenter?.onSaveButtonClick(b)
            }
        }
    }

    override fun navigateToBookList() {
        MAIN.navController.navigate(R.id.action_addBook_to_bookList)
    }
}