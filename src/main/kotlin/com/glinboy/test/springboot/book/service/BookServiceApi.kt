package com.glinboy.test.springboot.book.service

import com.glinboy.test.springboot.book.entity.Book
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface BookServiceApi {
    fun getBooks(pageable: Pageable): Page<Book>
    fun getBook(id: Long): Optional<Book>
    fun saveBook(book: Book): Book
    fun deleteBook(id: Long)
}
