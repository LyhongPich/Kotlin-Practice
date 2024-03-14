package com.example.demo.tp11.repositories

import com.example.demo.tp11.models.Hotel
import org.springframework.data.jpa.repository.JpaRepository

interface HotelRepository: JpaRepository<Hotel,Int> {

}