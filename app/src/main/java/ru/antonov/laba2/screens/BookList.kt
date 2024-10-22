package ru.antonov.laba2.screens

import android.os.Bundle
import android.util.Log
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

private lateinit var adapter: CustomAdapter

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

        Log.d(this.javaClass.name, "onViewCreated")

        init()

        if(::adapter.isInitialized){
           update()
        }

    }

    private fun init(){
        val rv : RecyclerView = binding.bookList
        val customAdapter = CustomAdapter(bookList)

        customAdapter.setItemOnClickListener(object : CustomAdapter.OnClickListener{
            override fun onClick(position: Int, model: Book) {
                Log.d(this.javaClass.name, "Кликнут ${position} элемент")
                dataModel.dataForBookInfo.value = model.copy()
                MAIN.navController.navigate(R.id.action_bookList_to_bookInfo)
            }
        })

        customAdapter.setDelButtonOnClickListener(object : CustomAdapter.OnClickListener{
            override fun onClick(position: Int, model: Book) {
                customAdapter.getDataList().removeAt(position)
                customAdapter.notifyItemRemoved(position)
                Log.d(this.javaClass.name, "Удален ${position} элемент")

            }
        })

        rv.adapter = customAdapter
        adapter = customAdapter

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv.layoutManager = layoutManager
        rv.addItemDecoration(
            DividerItemDecoration(
                context,
                layoutManager.orientation
            )
        )

        val btnAddBook = binding.addBookButton
        btnAddBook.setOnClickListener{
            MAIN.navController.navigate(R.id.action_bookList_to_addBook)
        }
    }

    private fun update(){
        dataModel.dataForBookListFromAddBook.observe(activity as LifecycleOwner){
            Log.d(this.javaClass.name, "observe data")

            it?.let {
                val position = if(adapter.itemCount == 0) 0 else adapter.itemCount
                adapter.getDataList().add(position, it)
                adapter.notifyItemInserted(position)
                dataModel.dataForBookListFromAddBook.value = null
            }
        }

        dataModel.dataForBookListFromEditBookInfo.observe(activity as LifecycleOwner) { data ->
            Log.d(this.javaClass.name, "observe data")

            data?.let {
                adapter.getDataList()
                    .stream()
                    .filter { it.id == data.id }
                    // Элемент только один! Потому что у каждого элемента уникальный ID
                    .forEach{
                        it.name = data.name
                        it.author = data.author
                        it.year = data.year
                        it.genre = data.genre
                    }

                adapter.notifyDataSetChanged()
                dataModel.dataForBookListFromEditBookInfo.value = null
            }
        }

    }

}