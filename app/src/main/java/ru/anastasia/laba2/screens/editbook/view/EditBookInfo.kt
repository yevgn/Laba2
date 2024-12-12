package ru.anastasia.laba2.screens.editbook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import ru.anastasia.laba2.entity.Book
import ru.anastasia.laba2.databinding.FragmentEditBookInfoBinding
import ru.anastasia.laba2.datamodel.DataModel
import ru.anastasia.laba2.screens.editbook.presenter.Presenter
import ru.anastasia.laba2.screens.editbook.presenter.PresenterImpl
import ru.anastasia.laba2.model.ModelImpl


class EditBookInfo : Fragment(), ru.anastasia.laba2.screens.editbook.view.View {

    private lateinit var binding: FragmentEditBookInfoBinding
    private val dataModel : DataModel by activityViewModels()
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
                Toast.makeText(context, "Данные были редактированы", Toast.LENGTH_SHORT).show()
                presenter?.onSaveButtonClick(Book(newName,newAuthor, newYear.toInt(), newGenre ))
            }
        }
    }

}