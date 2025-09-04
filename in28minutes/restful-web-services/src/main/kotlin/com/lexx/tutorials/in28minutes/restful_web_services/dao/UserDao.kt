package com.lexx.tutorials.in28minutes.restful_web_services.dao

import com.lexx.tutorials.in28minutes.restful_web_services.users.User
import jdk.jshell.spi.ExecutionControl.NotImplementedException
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class UserDao {


    companion object {
        var usersCount = 0L

        var adam = User(++usersCount , "Adam", LocalDate.now().minusYears(281))
        var eve = User(++usersCount, "Eve", LocalDate.now().minusYears(285))
        var jim = User(++usersCount, "Jim", LocalDate.now().minusYears(51))
        var alex = User(++usersCount, "Alex", LocalDate.now().minusYears(41))

        var users: MutableList<User> = mutableListOf(adam, eve, jim, alex )
    }

    fun findAll(): List<User> {
        return users
    }

    fun findById(id: Long): User? = users.find { it.id == id }

    fun create(user: User): User? {
        user.id=++usersCount
        users.add(user)
        return user
    }

    fun delete(user: User) {
        users.remove(user)
    }

    fun update(user: User?) {
        throw NotImplementedException("not implemented")
    }


}