package com.glinboy.test.springboot.book

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootBookApplication

fun main(args: Array<String>) {
    runApplication<SpringBootBookApplication>(*args)
}
