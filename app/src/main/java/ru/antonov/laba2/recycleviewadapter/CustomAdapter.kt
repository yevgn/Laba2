package ru.antonov.laba2.recycleviewadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.antonov.laba2.R

class CustomAdapter(private val bookNames : List<String>) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tvBookName = itemView.findViewById<TextView>(R.id.book_name)
        val ibDeleteBook = itemView.findViewById<ImageButton>(R.id.delete_book)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_list_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookNames.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.tvBookName.text = bookNames[position]
    }

}