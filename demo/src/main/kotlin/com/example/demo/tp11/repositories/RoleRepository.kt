package com.example.demo.tp11.repositories

import com.example.demo.tp11.models.Role
import org.springframework.data.jpa.repository.JpaRepository


interface RoleRepository: JpaRepository<Role, Int> {

}