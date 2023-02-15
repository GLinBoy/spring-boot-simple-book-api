package com.glinboy.test.springboot.book.service

import com.glinboy.test.springboot.book.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface UserServiceApi {
    fun getUsers(pageable: Pageable): Page<User>
    fun getUser(id: String): Optional<User>
    fun saveUser(book: User): User
    fun deleteUser(id: String)
    fun register(user: User)
}
