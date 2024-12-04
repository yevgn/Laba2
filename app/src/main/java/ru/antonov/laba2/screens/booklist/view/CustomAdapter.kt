package ru.antonov.laba2.screens.booklist.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.antonov.laba2.R
import ru.antonov.laba2.entity.Book

private var books: MutableList<Book> = mutableListOf()

class CustomAdapter(bookList: MutableList<Book>) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    private var itemOnClickListener: OnClickListener? = null
    private var delButtonOnClickListener: OnClickListener? = null

    init {
        books = bookList
    }

   class CustomViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
       val tvBookName = itemView.findViewById<TextView>(R.id.book_name)
       val ibDeleteBook = itemView.findViewById<ImageButton>(R.id.delete_book)

       fun setDelButtonOnClickListener(listener: OnClickListener?) {
           this.ibDeleteBook.setOnClickListener{
               listener?.onClick(adapterPosition, books[adapterPosition])
           }
       }
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
       val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.book_list_item, parent, false)
       return CustomViewHolder(view)
   }

   override fun getItemCount(): Int {
       return books.size
   }

   override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
       val item = books[position]
       holder.tvBookName.text = item.name

       holder.itemView.setOnClickListener{
           itemOnClickListener?.onClick(position, books[position])
       }

       holder.setDelButtonOnClickListener(delButtonOnClickListener)
   }

    interface OnClickListener {
       fun onClick(position: Int, model: Book)
    }

    fun setItemOnClickListener(listener: OnClickListener){
        this.itemOnClickListener = listener
    }

    fun setDelButtonOnClickListener(listener: OnClickListener){
        this.delButtonOnClickListener = listener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(bookList: MutableList<Book>){
        books.clear()
        books.addAll(bookList)
        notifyDataSetChanged()
    }

//     fun getDataList(): MutableList<Book> {
//        return BOOKS
//     }

}