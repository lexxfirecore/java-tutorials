package com.lexx.tutorials.in28minutes.restful_web_services.controller

import com.lexx.tutorials.in28minutes.restful_web_services.service.UserService
import com.lexx.tutorials.in28minutes.restful_web_services.users.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import java.time.LocalDate

@RestController
class UserController(
    private val userService: UserService
) {
    @GetMapping("/users")
    fun getAllUsers(): List<User> = userService.findAll();

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<Any> {
        val foundUser = userService.findById(id)
        return ResponseEntity.ok(foundUser ?: "User with id:$id not found.")
    }

    @PostMapping("/users")
    fun createUser(@RequestBody user: User): ResponseEntity<Any> {
        val createdUser = userService.create(user)
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/users/{id}")
            .buildAndExpand(createdUser!!.id)
            .toUri()

        return ResponseEntity.created(location).build()
    }

    @PostMapping("/users/jane")
    fun createUserJane(): ResponseEntity<Any> {
        return createUser(User(0, "Jane", LocalDate.now().minusYears(10)))
    }


}