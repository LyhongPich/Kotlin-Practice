package com.example.demo.tp11.repositories

import com.example.demo.tp11.models.Country
import org.springframework.data.jpa.repository.JpaRepository

interface CountryRepository: JpaRepository<Country, Int> {

}