package ru.antonov.laba2.screens.bookinfo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import ru.antonov.laba2.entity.Book
import ru.antonov.laba2.constant.MAIN
import ru.antonov.laba2.R
import ru.antonov.laba2.screens.bookinfo.presenter.Presenter
import ru.antonov.laba2.screens.bookinfo.presenter.PresenterImpl
import ru.antonov.laba2.databinding.FragmentBookInfoBinding
import ru.antonov.laba2.datamodel.DataModel

class BookInfo : Fragment(), ru.antonov.laba2.screens.bookinfo.view.View {

    private lateinit var binding: FragmentBookInfoBinding
    private val dataModel : DataModel by activityViewModels()
    private var presenter: Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookInfoBinding.inflate(layoutInflater, container, false)
        presenter = PresenterImpl(this, dataModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter?.loadInfo()

        binding.editDataButton.setOnClickListener {
            presenter?.onEditButtonClick()
        }
    }

    override fun showInfo(b: Book) {
        binding.bookNameTv.text = b.name
        binding.bookAuthorTv.text = b.author
        binding.bookYearTv.text = b.year.toString()
        binding.bookGenreTv.text = b.genre
    }

}