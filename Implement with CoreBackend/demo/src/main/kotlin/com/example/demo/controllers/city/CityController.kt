package com.example.demo.controllers.city

import com.example.demo.models.city.City
import com.example.demo.services.city.CityServiceImpl
import com.ig.core_backend.core.GenericRestfulController
import com.ig.core_backend.core.response.ResponseDTO
import com.ig.core_backend.utilities.AppConstant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(AppConstant.MAIN_PATH+"/city")
class CityController: GenericRestfulController<City>() {

    @Autowired
    lateinit var cityService: CityServiceImpl

    @PostMapping("/add/{countryid}")
    fun add(@PathVariable countryid: Long, @RequestBody city: City): ResponseDTO {
        val country = cityService.getCountry(countryid)
        return JSONFormat.respondObj(cityService.addNew(City(null, city.city, country)))
    }
}