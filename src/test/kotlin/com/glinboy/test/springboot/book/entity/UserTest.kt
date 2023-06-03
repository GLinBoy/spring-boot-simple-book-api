package com.glinboy.test.springboot.book.entity

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserTest {
    companion object{
        const val EMAIL = "test@test.com"
        const val PASSWORD = "\$2a\$13\$MwkF0KlOWl.W/LtZ.nT/OuaENtyr8wmYdikAGmXVm7AyUvG.QGkUm"
        const val ROLES = "ROLE_USER"
    }

    @Test
    fun verifyEquals() {
        var user1 = User(EMAIL, PASSWORD, ROLES)
        var user2 = user1.copy(EMAIL, PASSWORD, ROLES)
        assertThat(user1 == user2).isTrue()
    }
}
