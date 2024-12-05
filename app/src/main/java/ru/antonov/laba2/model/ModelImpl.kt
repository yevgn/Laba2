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
        val book : Book? = findBook { it.id == id }
        if(book != null){
            book.name = b.name
            book.author = b.author
            book.year = b.year
            book.genre = b.genre
        }
    }

    override fun putBook(name: String, b: Book) {
        val book : Book? =  findBook { it.name == name }
        if(book != null){
            book.name = b.name
            book.author = b.author
            book.year = b.year
            book.genre = b.genre
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