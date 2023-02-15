package com.glinboy.test.springboot.book.repository

import com.glinboy.test.springboot.book.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, String> {
}
