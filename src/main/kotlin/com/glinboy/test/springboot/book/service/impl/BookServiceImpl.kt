package com.glinboy.test.springboot.book.service.impl

import com.glinboy.test.springboot.book.entity.Book
import com.glinboy.test.springboot.book.repository.BookRepository
import com.glinboy.test.springboot.book.service.BookServiceApi
import com.glinboy.test.springboot.book.service.dto.BookDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class BookServiceImpl(val bookRepository: BookRepository): BookServiceApi {
    override fun getBooks(pageable: Pageable): Page<BookDTO> = bookRepository
        .findAll(pageable)
        .map { BookDTO(it.id, it.title, it.author, it.isbn) }

    override fun getBook(id: Long): Optional<BookDTO> = bookRepository
        .findById(id)
        .map { BookDTO(it.id, it.title, it.author, it.isbn) }
    override fun saveBook(bookDTO: BookDTO): BookDTO {
        var book = Book(bookDTO.id, bookDTO.title, bookDTO.author, bookDTO.isbn)
        book = bookRepository.save(book)
        return BookDTO(book.id, book.title, book.author, book.isbn)
    }
    override fun deleteBook(id: Long) = bookRepository.deleteById(id)
}
