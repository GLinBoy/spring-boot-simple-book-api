package com.glinboy.test.springboot.book.web.api

import com.glinboy.test.springboot.book.service.BookServiceApi
import com.glinboy.test.springboot.book.service.dto.BookDTO
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/books")
class BookResource(val bookService: BookServiceApi) {

    @GetMapping
    fun getBooks(@Parameter(hidden = true) pageable: Pageable): ResponseEntity<Page<BookDTO>> =
        ResponseEntity.ok(bookService.getBooks(pageable))

    @GetMapping("{id}")
    fun getBook(@PathVariable id: Long): ResponseEntity<BookDTO> =
        bookService.getBook(id)
            .map { ResponseEntity.ok(it) }
            .orElseGet { ResponseEntity.notFound().build() }

    @PostMapping
    fun addBook(@RequestBody bookDTO: BookDTO): ResponseEntity<BookDTO> =
        ResponseEntity(bookService.saveBook(bookDTO), HttpStatus.CREATED)

    @DeleteMapping("{id}")
    fun deleteBook(@PathVariable id: Long): ResponseEntity<Unit> {
        bookService.deleteBook(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping
    fun updateBook(@RequestBody bookDTO: BookDTO): ResponseEntity<BookDTO> {
        if (bookDTO.id == null) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Book should have ID to update")
        }
        return ResponseEntity.ok(bookService.saveBook(bookDTO))
    }
}
