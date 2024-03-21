package com.example.demo.controllers.city

import com.example.demo.models.city.City
import com.example.demo.services.city.CityServiceImpl
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
@RequestMapping(AppConstant.MAIN_PATH+"/city")
class CityController: GenericRestfulController<City>() {

    @Autowired
    lateinit var cityService: CityServiceImpl

    @PostMapping("/add/{countryid}")
    fun add(@PathVariable countryid: Long, @RequestBody city: City): ResponseDTO {
        val country = cityService.getCountry(countryid)
        return JSONFormat.respondObj(cityService.addNew(City(null, city.city, country)))
    }

    @PutMapping("/update/{cityid}")
    fun edit(@PathVariable cityid: Long, @RequestBody city: City): ResponseDTO {
        return JSONFormat.respondObj(cityService.update(cityid, city))
    }

    @GetMapping("/view")
    fun list(): ResponseDTO {
        return JSONFormat.respondList(cityService.findAll())
    }

    @GetMapping("/view/{cityid}")
    fun listOne(@PathVariable cityid: Long): ResponseDTO {
        return JSONFormat.respondObj(cityService.findById(cityid))
    }

    @GetMapping("/view-page/{page_num}/{page_size}")
    fun listByPage(@PathVariable page_num: Int, @PathVariable page_size: Int): ResponseDTO {
        return JSONFormat.respondPage(cityService.findAllByPage(page_num, page_size))
    }

    @GetMapping("/filter/{city}/{page_num}/{page_size}")
    fun listAllByPage(@PathVariable city: String, @PathVariable page_num: Int, @PathVariable page_size: Int): ResponseDTO {
        return JSONFormat.respondPage(cityService.findAllList(city, page_num, page_size))
    }

}