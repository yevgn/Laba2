package ru.antonov.laba2.screens.booklist.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.antonov.laba2.databinding.BookListItemBinding
import ru.antonov.laba2.entity.Book

private var books: MutableList<Book> = mutableListOf()

class CustomAdapter(bookList: MutableList<Book>) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    private var itemOnClickListener: OnClickListener? = null
    private var delButtonOnClickListener: OnClickListener? = null

    init {
        books = bookList
    }

   class CustomViewHolder(val binding: BookListItemBinding) : RecyclerView.ViewHolder(binding.root){

       fun setDelButtonOnClickListener(listener: OnClickListener?) {
           binding.deleteBook.setOnClickListener{
               listener?.onClick(adapterPosition, books[adapterPosition])
           }
       }
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
       val binding = BookListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
       return CustomViewHolder(binding)
   }

   override fun getItemCount(): Int {
       return books.size
   }

   override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
       val item = books[position]
       holder.binding.bookName.text = item.name

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
}