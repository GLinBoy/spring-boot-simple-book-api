package com.glinboy.test.springboot.book.repository

import com.glinboy.test.springboot.book.entity.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<Book, Long> {
}
