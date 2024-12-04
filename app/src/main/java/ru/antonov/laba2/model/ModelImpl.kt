package ru.antonov.laba2.model

import ru.antonov.laba2.constant.bookList
import ru.antonov.laba2.entity.Book
import java.util.function.Predicate

class ModelImpl : Model {
    override fun getBook(name: String): Book? {
       return findBook { it.name == name}
    }

    override fun getBook(id: Int): Book?{
        return findBook { it.id == id}
    }

    override fun postBook(b: Book) {
        bookList.add(b)
    }

    override fun putBook(id: Int, b: Book) {
        var book : Book? = findBook { it.id == id }
        if(book != null){
            book = b
            book.id = id
        }
    }

    // TODO: REWORK
    override fun putBook(name: String, b: Book) {
        var book : Book? =  findBook { it.name == name }
        if(book != null){
            deleteBook(name)
            val id = book.id
            book = b
            book.id = id
            postBook(book)
        }
    }

    override fun deleteBook(id: Int) {
        val book : Book? = findBook { it.id == id}
        if(book != null){
            bookList.remove(book)
        }
    }

    override fun deleteBook(name: String) {
        val book : Book? = findBook { it.name == name }
        if(book != null){
            bookList.remove(book)
        }
    }

    override fun deleteBook(b: Book) {
        bookList.remove(b)
    }

    private fun findBook(filter: Predicate<Book>): Book? {
        return bookList.stream().filter(filter).findAny().orElse(null)
    }
}