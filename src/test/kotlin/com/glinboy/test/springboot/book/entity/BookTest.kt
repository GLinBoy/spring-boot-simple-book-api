package com.glinboy.test.springboot.book.entity

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BookTest {
    companion object {
        const val ID = 10001L
        const val TITLE = "Test Title"
        const val AUTHOR = "Test Author"
        const val ISBN = "978-3-16-148410-0"
    }

    @Test
    fun verifyEquals() {
        var book1 = Book(ID, TITLE, AUTHOR, ISBN)
        var book2 = book1.copy(ID, TITLE, AUTHOR, ISBN)
        assertThat(book1 == book2).isTrue()
    }
}
