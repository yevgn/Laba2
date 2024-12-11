package ru.antonov.laba2.model

import ru.antonov.laba2.constant.bookList
import ru.antonov.laba2.entity.Book
import java.util.function.Predicate

class ModelImpl : Model {

    override fun getBook(name: String): Book? {
       return filterData { it.name == name}
    }

    override fun getBook(id: Int): Book?{
        return filterData { it.id == id}
    }

    override fun getAllBooks(): MutableList<Book> {
        return bookList.toMutableList()
    }

    override fun postBook(b: Book) {
        bookList.add(b)
    }

    override fun putBook(id: Int, b: Book) {
        val book = filterData { it.id == id }
        if(book!= null){
            book.name = b.name
            book.author = b.author
            book.year = b.year
            book.genre = b.genre
        }
    }

    override fun putBook(name: String, b: Book) {
        val book = filterData { it.name == name }
        if(book!= null){
            book.name = b.name
            book.author = b.author
            book.year = b.year
            book.genre = b.genre
        }
    }

    override fun deleteBook(id: Int) {
        val book = filterData { it.id == id}
        if(book!=null){
            bookList.remove(book)
        }
    }

    override fun deleteBook(name: String) {
        val book = filterData { it.name == name}
        if(book!=null){
            bookList.remove(book)
        }
    }

    override fun deleteBook(b: Book) {
        bookList.remove(b)
    }

    private fun filterData(filter: Predicate<Book>): Book? {
        return bookList.stream().filter(filter).findAny().orElse(null)
    }
}