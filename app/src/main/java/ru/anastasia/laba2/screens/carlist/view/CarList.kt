package ru.anastasia.laba2.screens.carlist.view

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
import ru.anastasia.laba2.screens.carlist.presenter.Presenter
import ru.anastasia.laba2.screens.carlist.presenter.PresenterImpl

import ru.anastasia.laba2.databinding.FragmentCarListBinding
import ru.anastasia.laba2.datamodel.DataModel
import ru.anastasia.laba2.entity.Car
import ru.anastasia.laba2.model.ModelImpl

class CarList : Fragment(), ru.anastasia.laba2.screens.carlist.view.View {
    private val dataModel : DataModel by activityViewModels()
    private var presenter: Presenter? = null

    private lateinit var binding : FragmentCarListBinding
    private lateinit var adapter: CustomAdapter
    private lateinit var rv : RecyclerView
    private lateinit var btnAddBook : ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarListBinding.inflate(layoutInflater, container, false)
        presenter = PresenterImpl(this, ModelImpl(), dataModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(this.javaClass.name, "onViewCreated")

        rv = binding.carList

        adapter = CustomAdapter(mutableListOf())

        presenter?.loadDataFromModel()

        adapter.setItemOnClickListener(object : CustomAdapter.OnClickListener {
            override fun onClick(position: Int, model: Car) {
                presenter?.onItemClick(model)
            }
        })

        adapter.setDelButtonOnClickListener(object  : CustomAdapter.OnClickListener {
            override fun onClick(position: Int, model: Car) {
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
    override fun showCars(carList: MutableList<Car>) {
        adapter.setData(carList)
    }

}