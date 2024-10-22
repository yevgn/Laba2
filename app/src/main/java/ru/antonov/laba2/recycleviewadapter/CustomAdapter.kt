package ru.antonov.laba2.recycleviewadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.antonov.laba2.R
import ru.antonov.laba2.entity.Book


var BOOKS: MutableList<Book> = mutableListOf()

 class CustomAdapter(bookList: MutableList<Book>) :
     RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

     private var itemOnClickListener: OnClickListener? = null
     private var delButtonOnClickListener: OnClickListener? = null

     init {
         BOOKS = bookList
     }

    class CustomViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tvBookName = itemView.findViewById<TextView>(R.id.book_name)
        val ibDeleteBook = itemView.findViewById<ImageButton>(R.id.delete_book)

        fun setDelButtonOnClickListener(listener: OnClickListener?) {
            this.ibDeleteBook.setOnClickListener{
                listener?.onClick(adapterPosition, BOOKS[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_list_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return BOOKS.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = BOOKS[position]
        holder.tvBookName.text = item.name

        holder.itemView.setOnClickListener{
            itemOnClickListener?.onClick(position, BOOKS[position])
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

     fun getDataList(): MutableList<Book> {
        return BOOKS
     }

}