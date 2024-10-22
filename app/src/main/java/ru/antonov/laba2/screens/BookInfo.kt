package ru.antonov.laba2.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import ru.antonov.laba2.entity.Book
import ru.antonov.laba2.MAIN
import ru.antonov.laba2.R
import ru.antonov.laba2.databinding.FragmentBookInfoBinding
import ru.antonov.laba2.datamodel.DataModel

class BookInfo : Fragment() {

    lateinit var binding: FragmentBookInfoBinding
    private val dataModel : DataModel by activityViewModels()
    lateinit var book : Book

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataModel.dataForBookInfo.observe(activity as LifecycleOwner) {
            book = it
            binding.bookNameTv.text = book.name
            binding.bookAuthorTv.text = book.author
            binding.bookYearTv.text = book.year.toString()
            binding.bookGenreTv.text = book.genre
        }

        binding.editDataButton.setOnClickListener {
            dataModel.dataForEditBookInfo.value = book.copy()
            MAIN.navController.navigate(R.id.action_bookInfo_to_editBookInfo)
        }
    }


}