package com.example.demo.tp11.repositories

import com.example.demo.tp11.models.Image
import org.springframework.data.jpa.repository.JpaRepository

interface ImageRepository: JpaRepository<Image, Int> {

}