package ru.antonov.laba2.screens.booklist.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.antonov.laba2.constant.MAIN
import ru.antonov.laba2.R
import ru.antonov.laba2.screens.booklist.presenter.Presenter
import ru.antonov.laba2.screens.booklist.presenter.PresenterImpl
import ru.antonov.laba2.databinding.FragmentBookListBinding
import ru.antonov.laba2.datamodel.DataModel
import ru.antonov.laba2.entity.Book
import ru.antonov.laba2.model.ModelImpl

class BookList : Fragment(), ru.antonov.laba2.screens.booklist.view.View {
    private val dataModel : DataModel by activityViewModels()
    private var presenter: Presenter? = null

    private lateinit var binding : FragmentBookListBinding
    private lateinit var adapter: CustomAdapter
    private lateinit var rv : RecyclerView
    private lateinit var btnAddBook : ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookListBinding.inflate(layoutInflater, container, false)
        presenter = PresenterImpl(this, ModelImpl(), dataModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(this.javaClass.name, "onViewCreated")

        rv = binding.bookList

        adapter = CustomAdapter(mutableListOf())

        presenter?.loadDataFromModel()

        adapter.setItemOnClickListener(object : CustomAdapter.OnClickListener {
            override fun onClick(position: Int, model: Book) {
                presenter?.onItemClick(model)
            }
        })

        adapter.setDelButtonOnClickListener(object  : CustomAdapter.OnClickListener {
            override fun onClick(position: Int, model: Book) {
                presenter?.onDeleteButtonClick(model)
            }
        })

        rv.adapter = adapter

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv.layoutManager = layoutManager
        rv.addItemDecoration(
            DividerItemDecoration(
                context,
                layoutManager.orientation
            )
        )

        btnAddBook = binding.addBookButton

        btnAddBook.setOnClickListener{
           presenter?.onAddButtonClick()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun showBooks(bookList: MutableList<Book>) {
        adapter.setData(bookList)
    }

    override fun navigateToInfo() {
        MAIN.navController.navigate(R.id.action_bookList_to_bookInfo)
    }

    override fun navigateToAddBook() {
        MAIN.navController.navigate(R.id.action_bookList_to_addBook)
    }

    //    private fun update(){
//        dataModel.dataForBookListFromAddBook.observe(activity as LifecycleOwner){
//            Log.d(this.javaClass.name, "observe data")
//
//            it?.let {
//                val position = if(adapter.itemCount == 0) 0 else adapter.itemCount
//                adapter.getDataList().add(position, it)
//                adapter.notifyItemInserted(position)
//                //adapter.notifyItemRangeChanged(position, myDataList.size());
//                dataModel.dataForBookListFromAddBook.value = null
//            }
//        }
//
//        dataModel.dataForBookListFromEditBookInfo.observe(activity as LifecycleOwner) { data ->
//            Log.d(this.javaClass.name, "observe data")
//
//            data?.let {
//                adapter.getDataList()
//                    .stream()
//                    .filter { it.id == data.id }
//                    // Элемент только один! Потому что у каждого элемента уникальный ID
//                    .forEach{
//                        it.name = data.name
//                        it.author = data.author
//                        it.year = data.year
//                        it.genre = data.genre
//                    }
//
//                adapter.notifyDataSetChanged()
//                dataModel.dataForBookListFromEditBookInfo.value = null
//            }
//        }
//
//    }
}