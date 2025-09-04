package com.lexx.tutorials.in28minutes.restful_web_services.service

import com.lexx.tutorials.in28minutes.restful_web_services.dao.UserDao
import com.lexx.tutorials.in28minutes.restful_web_services.users.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userDao: UserDao
) {
    fun findAll(): List<User> = userDao.findAll()

    fun findById(id: Long): User? = userDao.findById(id)

    fun create(user: User): User? = userDao.create(user)

    fun deleteUser(user: User) {
        userDao.delete(user)
    }

}