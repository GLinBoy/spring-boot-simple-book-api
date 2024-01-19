package com.glinboy.test.springboot.book.service

import com.glinboy.test.springboot.book.entity.Book
import com.glinboy.test.springboot.book.service.dto.BookDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface BookServiceApi {
    fun getBooks(pageable: Pageable): Page<BookDTO>
    fun getBook(id: Long): Optional<BookDTO>
    fun saveBook(book: Book): BookDTO
    fun deleteBook(id: Long)
}
