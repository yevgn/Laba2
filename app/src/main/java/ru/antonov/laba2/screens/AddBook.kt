package ru.antonov.laba2.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import ru.antonov.laba2.entity.Book
import ru.antonov.laba2.MAIN
import ru.antonov.laba2.R
import ru.antonov.laba2.databinding.FragmentAddBookBinding
import ru.antonov.laba2.datamodel.DataModel

class AddBook : Fragment() {

    lateinit var binding : FragmentAddBookBinding
    private val dataModel : DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBookBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.saveDataButton.setOnClickListener {
            val name = binding.bookNameEt.text.toString()
            val author = binding.bookAuthorEt.text.toString()
            val year  = binding.bookYearEt.text.toString()
            val genre  = binding.bookGenreEt.text.toString()

            if(name.isEmpty() || author.isEmpty() || year.isEmpty()
                || genre.isEmpty()){

                Toast.makeText(
                    context, "Остались незаполненные поля", Toast.LENGTH_SHORT
                ).show()

            }

            else{
                val b = Book(name, author, year.toInt(), genre)
                println("AddBook + ${b.toString()}")
                dataModel.dataForBookListFromAddBook.value = b
                Toast.makeText(context, "Книга была добавлена", Toast.LENGTH_SHORT).show()
                MAIN.navController.navigate(R.id.action_addBook_to_bookList)
            }
        }

    }


}