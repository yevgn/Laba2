package ru.antonov.laba2.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.antonov.laba2.entity.Book
import ru.antonov.laba2.MAIN
import ru.antonov.laba2.R
import ru.antonov.laba2.bookList
import ru.antonov.laba2.databinding.FragmentBookListBinding
import ru.antonov.laba2.datamodel.DataModel
import ru.antonov.laba2.recycleviewadapter.CustomAdapter


class BookList : Fragment() {

    lateinit var binding : FragmentBookListBinding
    private val dataModel : DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println("BookList onViewCreated")
        init()
    }

    private fun init(){
        val rv : RecyclerView = binding.bookList
        val customAdapter = CustomAdapter(bookList)

        customAdapter.setItemOnClickListener(object : CustomAdapter.OnClickListener{
            override fun onClick(position: Int, model: Book) {
                println("Кликнут ${position} элемент" )
                dataModel.dataForBookInfo.value = model.copy()
                MAIN.navController.navigate(R.id.action_bookList_to_bookInfo)
            }
        })

        customAdapter.setDelButtonOnClickListener(object : CustomAdapter.OnClickListener{
            override fun onClick(position: Int, model: Book) {
                println("Удален ${position} элемент" )
                customAdapter.getDataList().removeAt(position)
                customAdapter.notifyItemRemoved(position)

            }
        })

        rv.adapter = customAdapter

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv.layoutManager = layoutManager
        rv.addItemDecoration(
            DividerItemDecoration(
                context,
                layoutManager.orientation
            )
        )

        dataModel.dataForBookListFromAddBook.observe(activity as LifecycleOwner){
            println("observe data from add book")
            val adapter = rv.adapter as CustomAdapter
            val position = if(adapter.itemCount == 0) 0 else adapter.itemCount - 1
            println("BookInfo + ${it.toString()}")
            adapter.getDataList().add(position, it)
            adapter.notifyItemInserted(position)
            // dataModel.dataForBookListFromAddBook.value = null
        }

        dataModel.dataForBookListFromEditBookInfo.observe(activity as LifecycleOwner) {
            val adapter = rv.adapter as CustomAdapter
            val editedBook = it

            adapter.getDataList()
                .stream()
                .filter { it.id == editedBook.id }
                // Элемент только один! Потому что у каждого элемента уникальный ID
                .forEach {
                    it.name = editedBook.name
                    it.author = editedBook.author
                    it.year = editedBook.year
                    it.genre = editedBook.genre
                }

            adapter.notifyDataSetChanged()
            // dataModel.dataForBookListFromEditBookInfo.value = null
        }

        val btnAddBook = binding.addBookButton
        btnAddBook.setOnClickListener{
            MAIN.navController.navigate(R.id.action_bookList_to_addBook)
        }
    }

}