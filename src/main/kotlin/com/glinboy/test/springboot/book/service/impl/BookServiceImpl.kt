package com.glinboy.test.springboot.book.service.impl

import com.glinboy.test.springboot.book.entity.Book
import com.glinboy.test.springboot.book.repository.BookRepository
import com.glinboy.test.springboot.book.service.BookServiceApi
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class BookServiceImpl(val bookRepository: BookRepository): BookServiceApi {
    override fun getBooks(pageable: Pageable): Page<Book> = bookRepository.findAll(pageable)

    override fun getBook(id: Long): Optional<Book> = bookRepository.findById(id)
    override fun saveBook(book: Book): Book = bookRepository.save(book)
    override fun deleteBook(id: Long) = bookRepository.deleteById(id)
}
