package com.example.demo.tp11.services

import com.example.demo.tp11.dto.CountryDto
import com.example.demo.tp11.models.Country
import com.example.demo.tp11.repositories.CountryRepository
import org.springframework.stereotype.Service

@Service
class CountryService(val countryRepository: CountryRepository) {
    fun save(c: CountryDto): Country {
        val country = Country(null, c.country)
        countryRepository.save(country)
        return country
    }

    fun list(): List<Country> {
        return countryRepository.findAll()
    }

    fun listCountryById(id: Int): Country {
        return countryRepository.findById(id).get()
    }

    fun update(id: Int, countryDto: CountryDto): Country {
        val country = listCountryById(id)
        country.country = countryDto.country
        countryRepository.save(country)
        return country
    }

    fun remove(id: Int): Country {
        val country = listCountryById(id)
        countryRepository.delete(country)
        return country
    }
}