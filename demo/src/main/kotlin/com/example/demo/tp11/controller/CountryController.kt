package com.example.demo.tp11.controller

import com.example.demo.tp11.dto.CountryDto
import com.example.demo.tp11.response.APIResponse
import com.example.demo.tp11.models.Country
import com.example.demo.tp11.services.CountryService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/country")
class CountryController(val countryService: CountryService) {

    @PostMapping("/add")
    fun addCountry(@RequestBody country: CountryDto): Country {
        return countryService.save(country)
    }

    @GetMapping("/view")
    fun viewAllCountry(): APIResponse<List<Country>> {
        val countries = countryService.list()
        return APIResponse(countries.size, countries)
    }

    @GetMapping("/view-by-name")
    fun viewOneCountryByName(@RequestBody country: CountryDto): Country {
        return countryService.listCountryByName(country)
    }

    @GetMapping("/sort/{field}")
    fun viewCountrySort(@PathVariable field: String): List<Country> {
        return countryService.listCountrySort(field)
    }

    @GetMapping("/pagination/{page_num}/{page_size}")
    fun viewCountryPagination(@PathVariable page_num: Int, @PathVariable page_size: Int): Page<Country> {
        return countryService.listCountryPagination(page_num, page_size)
    }

    @GetMapping("/sort-and-page/{field}/{page_num}/{page_size}")
    fun viewCountrySortAndPage(@PathVariable field: String, @PathVariable page_num: Int, @PathVariable page_size: Int): Page<Country> {
        return countryService.listCountrySortAndPagination(page_num, page_size, field)
    }

    @GetMapping("/filter-start/{pattern}")
    fun viewCountryFilter(@PathVariable pattern: String): APIResponse<List<Country>> {
        val countries = countryService.filterByStart(pattern)
        return APIResponse(countries.size, countries)
    }

    @GetMapping("/filter/{pattern}")
    fun viewCountryFilterAny(@PathVariable pattern: String): APIResponse<List<Country>> {
        val countries = countryService.filter(pattern)
        return APIResponse(countries.size, countries)
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