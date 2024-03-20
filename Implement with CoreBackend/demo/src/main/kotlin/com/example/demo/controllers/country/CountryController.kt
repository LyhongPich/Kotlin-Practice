package com.example.demo.controllers.country

import com.example.demo.models.country.Country
import com.example.demo.services.country.CountryServiceImpl
import com.ig.core_backend.core.GenericRestfulController
import com.ig.core_backend.core.response.ResponseDTO
import com.ig.core_backend.utilities.AppConstant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(AppConstant.MAIN_PATH+"/country")
class CountryController: GenericRestfulController<Country>() {

    @Autowired
    lateinit var countryService: CountryServiceImpl


    @GetMapping("/view/{id}")
    fun listOne(@PathVariable id: Long): ResponseDTO {
        return JSONFormat.respondObj(countryService.findById(id))
    }

    @GetMapping("/view")
    fun list(): ResponseDTO {
        return JSONFormat.respondList(countryService.findAll())
    }

    @GetMapping("/view-page/{page_num}/{page_size}")
    fun listByPage(@PathVariable page_num: Int, @PathVariable page_size: Int): ResponseDTO {
        return JSONFormat.respondPage(countryService.findAllByPage(page_num, page_size))
    }

    @GetMapping("/filter/{country}/{page_num}/{page_size}")
    fun listAllByPage(@PathVariable country: String, @PathVariable page_num: Int, @PathVariable page_size: Int): ResponseDTO {
        return JSONFormat.respondPage(countryService.findAllList(country, page_num, page_size))
    }

    @PostMapping("/add")
    fun add(@RequestBody country: Country): ResponseDTO {
        return JSONFormat.respondObj(countryService.addNew(country))
    }

    @PutMapping("/update/{id}")
    fun edit(@PathVariable id: Long,@RequestBody country: Country): ResponseDTO {
        return JSONFormat.respondObj(countryService.update(id, country))
    }
}