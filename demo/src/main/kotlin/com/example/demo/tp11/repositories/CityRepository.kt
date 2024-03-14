package com.example.demo.tp11.repositories

import com.example.demo.tp11.models.City
import org.springframework.data.jpa.repository.JpaRepository

interface CityRepository: JpaRepository<City, Int> {

}