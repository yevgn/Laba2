package ru.antonov.laba2.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import ru.antonov.laba2.MAIN
import ru.antonov.laba2.R
import ru.antonov.laba2.entity.Book
import ru.antonov.laba2.databinding.FragmentEditBookInfoBinding
import ru.antonov.laba2.datamodel.DataModel


class EditBookInfo : Fragment() {

    lateinit var binding: FragmentEditBookInfoBinding
    private val dataModel : DataModel by activityViewModels()
    private var book: Book? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBookInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataModel.dataForEditBookInfo.observe(activity as LifecycleOwner){
             book = it
        }

        binding.saveDataButton.setOnClickListener {
            val newName = binding.bookNameEt.text.toString()
            val newAuthor = binding.bookAuthorEt.text.toString()
            val newYear  = binding.bookYearEt.text.toString()
            val newGenre   = binding.bookGenreEt.text.toString()

            if(newName.isEmpty() || newAuthor.isEmpty() || newYear.isEmpty()
                || newGenre.isEmpty()){

                Toast.makeText(
                    context, "Остались незаполненные поля", Toast.LENGTH_SHORT
                ).show()

            }

            else{
                val editedBook = book?.copy(name =  newName, author = newAuthor,
                    year = newYear.toInt(), genre = newGenre)

                dataModel.dataForBookInfo.value = editedBook
                dataModel.dataForBookListFromEditBookInfo.value = editedBook

                Toast.makeText(context, "Данные были редактированы", Toast.LENGTH_SHORT).show()
                MAIN.navController.navigate(R.id.action_editBookInfo_to_bookInfo)
            }
        }

    }
}