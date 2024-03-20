package com.example.demo.services.city

import com.example.demo.models.city.City
import com.example.demo.models.country.Country
import com.example.demo.repositories.city.CityRepository
import com.example.demo.repositories.country.CountryRepository
import com.ig.core_backend.utilities.UtilService
import jakarta.persistence.criteria.Predicate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class CityServiceImpl: CityService {

    @Autowired
    lateinit var countryRepository: CountryRepository

    @Autowired
    lateinit var utilService: UtilService

    @Autowired
    lateinit var cityRepository: CityRepository

    override fun addNew(t: City): City? {
        beforeSaveOrUpdate(t)
        val city = cityRepository.save(t)
        city.id?.let { afterSave(it) }
        return city
    }

    fun getCountry(id: Long): Country {
        return countryRepository.findById(id).get()
    }

    fun beforeSaveOrUpdate(t: City) {
        if (t.city.isEmpty() || t.city.isBlank()) {
            throw NullPointerException("City can not be empty!")
        }
        for (city in cityRepository.findAll()) {
            if (t.city == city.city) {
                throw IllegalStateException("${t.city} is already existed!")
            }
        }
    }

    fun afterSave(id: Long) {
        val city = cityRepository.findById(id).get()
        city.created = Date()
        cityRepository.save(city)
    }

    override fun findAll(): List<City>? {
        return cityRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
    }

    override fun findAllList(q: String?, page: Int, size: Int): Page<City>? {
        return cityRepository.findAll({root, _, cb ->
            val predicates = ArrayList<Predicate>()
            if (q != null) {
                val city = cb.like(cb.upper(root.get("city")), "%${q.uppercase()}%")
                predicates.add(city)
            }
            predicates.add(cb.isTrue(root.get("status")))
            cb.and(*predicates.toTypedArray())
        }, PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id")))
    }

    override fun findById(id: Long): City? {
        return cityRepository.findById(id).get()
    }

    fun update(id: Long, t: City): City? {
        beforeSaveOrUpdate(t)
        val city = updateObj(id, t)
        city?.id?.let{ afterUpdate(it) }
        return city
    }

    override fun updateObj(id: Long, t: City): City? {
        val city = cityRepository.findById(id).get()

        utilService.bindProperties(t, city, exclude = listOf("id","hotels"))

        city.hotels?.clear()
        city.hotels?.addAll(city.hotels?: listOf())

        return cityRepository.save(city)
    }

    fun afterUpdate(id: Long) {
        val city = cityRepository.findById(id).get()
        city.updated = Date()
        city.version = city.version!!+1
        cityRepository.save(city)
    }
}