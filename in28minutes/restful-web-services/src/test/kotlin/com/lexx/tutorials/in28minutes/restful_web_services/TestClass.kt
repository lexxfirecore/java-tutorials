package com.lexx.tutorials.in28minutes.restful_web_services

import com.lexx.tutorials.in28minutes.restful_web_services.users.User
import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat
import org.springframework.web.client.RestTemplate
import java.time.LocalDate

class TestClass {
    private val restTemplate = RestTemplate()

    @Test
    fun `should create a new User`() {
        val user = User(0, "John", LocalDate.now().minusYears(10))
        val response = restTemplate.postForObject("http://localhost:8080/users", user, String::class.java)
        assertThat(response).isNotNull
        assertThat(response!!.contains("Created user with id: ")).isTrue()
    }

    @Test
    fun `should create a new User Jane`() {
        val response = restTemplate.postForObject("http://localhost:8080/users/jane", null, Any::class.java)
        assertThat(response).isNotNull
      //  assertThat(response!!.contains("Created user with id: ")).isTrue()
    }

}

