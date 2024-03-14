package com.example.demo.tp11.controller

import com.example.demo.tp11.dto.CountryDto
import com.example.demo.tp11.models.Country
import com.example.demo.tp11.services.CountryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/country")
class CountryController(val countryService: CountryService) {

    @PostMapping("/add")
    fun addCountry(@RequestBody country: CountryDto): Country {
        return countryService.save(country)
    }

    @GetMapping("/view")
    fun viewAllCountry(): List<Country> {
        return countryService.list()
    }

    @PutMapping("/edit/{id}")
    fun editCountry(@PathVariable id: Int,@RequestBody countryDto: CountryDto): Country {
        return countryService.update(id, countryDto)
    }
    @DeleteMapping("/remove/{id}")
    fun removeCountry(@PathVariable id: Int): Country {
        return countryService.remove(id)
    }
}