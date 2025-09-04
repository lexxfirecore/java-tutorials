package com.lexx.tutorials.in28minutes.restful_web_services.controller

import com.lexx.tutorials.in28minutes.restful_web_services.model.HelloWorldBean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping
    fun getHome(): String = "Root - Home Page."

    @GetMapping("/hello-world")
    fun getHelloWorld(): String = "Hello World."

    @GetMapping("/hello-world-bean")
    fun getHelloWorldBean(): HelloWorldBean = HelloWorldBean("World")

    @GetMapping("/hello-world/path-variable/{name}")
    fun getHelloWorldPathVariable(@PathVariable(value = "name") name: String): String = "Hello world '$name'."

}