package com.example.demo.services.hotel

import com.example.demo.models.city.City
import com.example.demo.models.hotels.Hotel
import com.example.demo.repositories.city.CityRepository
import com.example.demo.repositories.hotel.HotelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class HotelServiceImpl: HotelService {

    @Autowired
    lateinit var cityRepository: CityRepository

    @Autowired
    lateinit var hotelRepository: HotelRepository

    override fun addNew(t: Hotel): Hotel? {
        TODO("Not yet implemented")
    }

    fun getCity(id: Long): City {
        return cityRepository.findById(id).get()
    }

    fun beforeSave(t: Hotel) {
        if (t.hotel.isBlank() || t.hotel.isEmpty()) {
            throw NullPointerException("Hotel cannot be empty!")
        }
    }

    override fun findAll(): List<Hotel>? {
        TODO("Not yet implemented")
    }

    override fun findAllList(q: String?, page: Int, size: Int): Page<Hotel>? {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Hotel? {
        TODO("Not yet implemented")
    }

    override fun updateObj(id: Long, t: Hotel): Hotel? {
        TODO("Not yet implemented")
    }
}