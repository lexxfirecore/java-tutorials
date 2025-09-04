package com.lexx.tutorials.in28minutes.restful_web_services.users

import java.time.LocalDate

data class User(var id: Long, val name: String, val birthDate: LocalDate)