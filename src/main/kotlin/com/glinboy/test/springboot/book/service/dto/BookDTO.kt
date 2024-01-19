package com.glinboy.test.springboot.book.service.dto

data class BookDTO(
    var id: Long? = null,
    var title: String,
    var author: String,
    var isbn: String
)
