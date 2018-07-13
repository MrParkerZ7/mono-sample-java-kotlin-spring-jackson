package com.example.jackson.ktspringjpajackson

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class UserController(@Autowired private val userRepository: UserRepository) {

    @GetMapping
    fun getAll(): List<User> = userRepository.findAll()

    @GetMapping("/message/{message}")
    fun getMessageLike(@PathVariable("message") message: String?): List<User> = userRepository.findByMessageLike(message)

    @GetMapping("/name/{name}")
    fun getByNameLike(@PathVariable("name") name: String?): List<User> = userRepository.findByNameIgnoreCaseLike(name)

}