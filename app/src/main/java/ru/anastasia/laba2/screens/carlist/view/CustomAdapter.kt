package ru.anastasia.laba2.screens.carlist.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.anastasia.laba2.databinding.CarListItemBinding
import ru.anastasia.laba2.entity.Car

private var cars: MutableList<Car> = mutableListOf()

class CustomAdapter(carList: MutableList<Car>) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    private var itemOnClickListener: OnClickListener? = null
    private var delButtonOnClickListener: OnClickListener? = null

    init {
        cars = carList
    }

   class CustomViewHolder(val binding: CarListItemBinding) : RecyclerView.ViewHolder(binding.root){

       fun setDelButtonOnClickListener(listener: OnClickListener?) {
           binding.deleteCar.setOnClickListener{
               listener?.onClick(adapterPosition, cars[adapterPosition])
           }
       }
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
       val binding = CarListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
       return CustomViewHolder(binding)
   }

   override fun getItemCount(): Int {
       return cars.size
   }

   override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
       val item = cars[position]
       holder.binding.carName.text = item.name

       holder.itemView.setOnClickListener{
           itemOnClickListener?.onClick(position, cars[position])
       }

       holder.setDelButtonOnClickListener(delButtonOnClickListener)
   }

    interface OnClickListener {
       fun onClick(position: Int, model: Car)
    }

    fun setItemOnClickListener(listener: OnClickListener){
        this.itemOnClickListener = listener
    }

    fun setDelButtonOnClickListener(listener: OnClickListener){
        this.delButtonOnClickListener = listener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(carList: MutableList<Car>){
        cars.clear()
        cars.addAll(carList)
        notifyDataSetChanged()
    }
}