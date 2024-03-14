package com.example.demo.tp11.repositories

import com.example.demo.tp11.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int> {
}