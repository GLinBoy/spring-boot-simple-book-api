package com.glinboy.test.springboot.book.service.impl

import com.glinboy.test.springboot.book.entity.User
import com.glinboy.test.springboot.book.repository.UserRepository
import com.glinboy.test.springboot.book.service.UserServiceApi
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class UserServiceImpl(private val repository: UserRepository): UserServiceApi {
    override fun register(user: User) {
        repository.findById(user.email).ifPresent {
            throw ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Email exist: %s".format(user.email)
            )
        }
        repository.save(user)
    }

    override fun getUsers(pageable: Pageable): Page<User> = repository.findAll(pageable)
    override fun getUser(id: String): Optional<User> = repository.findById(id)
    override fun saveUser(user: User): User = repository.save(user)
    override fun deleteUser(id: String) = repository.deleteById(id)
}
