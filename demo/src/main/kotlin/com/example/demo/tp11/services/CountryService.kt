package com.example.demo.tp11.services

import com.example.demo.tp11.dto.CountryDto
import com.example.demo.tp11.models.Country
import com.example.demo.tp11.repositories.CountryRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
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

    fun listCountryByName(countryDto: CountryDto): Country {
        return countryRepository.findByCountry(countryDto.country)
    }

    fun listCountrySort(field: String): List<Country> {
        return countryRepository.findAll(Sort.by(Sort.Direction.ASC, field))
    }

    fun listCountryPagination(page_number: Int, page_size: Int): Page<Country> {
        val country_pagination =  countryRepository.findAll(PageRequest.of(page_number, page_size))
        return country_pagination
    }

    fun listCountrySortAndPagination(page_number: Int, page_size: Int, field: String): Page<Country>{
        val countrySortAndPage = countryRepository.findAll(PageRequest.of(page_number, page_size, Sort.by(Sort.Direction.ASC, field)))
        return countrySortAndPage
    }

    fun filterByStart(pattern: String): List<Country> {
        return countryRepository.findByCountryStartingWith(pattern)
    }

    fun filter(pattern: String): List<Country> {
        return countryRepository.findByCountryContaining(pattern)
    }

}