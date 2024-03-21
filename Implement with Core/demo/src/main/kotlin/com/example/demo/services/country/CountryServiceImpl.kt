package com.example.demo.services.country

import com.example.demo.models.country.Country
import com.example.demo.repositories.country.CountryRepository
import com.ig.core_backend.utilities.UtilService
import jakarta.persistence.criteria.Predicate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.Date

@Service
class CountryServiceImpl: CountryService {

    @Autowired
    lateinit var countryRepository: CountryRepository

    @Autowired
    lateinit var utilService: UtilService

    override fun addNew(t: Country): Country? {
        val save = countryRepository.save(t)
        return save
    }

    fun beforeSave(t: Country) {
        if (t.country.isEmpty() || t.country.isBlank()) {
            throw NullPointerException("Country can not be empty!")
        }
        for (country in countryRepository.findAll()) {
            if (t.country == country.country) {
                throw IllegalStateException("Unable to add ${t.country} due to existing data!")
            }
        }
    }

    /**
     * @Usage set the created date for adding country
     */
    fun afterSave(id: Long) {
        val findCountry = countryRepository.findById(id).get()
        findCountry.created = Date()
        countryRepository.save(findCountry)
    }

    override fun findAll(): List<Country>? {
        return countryRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
    }

    fun findAllByPage(pageNum: Int, pageSize: Int): Page<Country> {
        return countryRepository.findAll(PageRequest.of(pageNum, pageSize, Sort.by(Sort.Direction.ASC, "id")))
    }

    /**
     * @param q is a searched data based on column country of Country entity
     *
     * @Do
     *      - compare query like and verify true status of entity
     *
     * @return Pageable format of list of country
     */
    override fun findAllList(q: String?, page: Int, size: Int): Page<Country>? {
        return countryRepository.findAll({root, _, cb ->
            val predicates = ArrayList<Predicate>()
            if (q != null) {
                val country = cb.like(cb.upper(root.get("country")), "%${q.uppercase()}%")
                predicates.add(country)
            }
            predicates.add(cb.isTrue(root.get("status")))
            cb.and(*predicates.toTypedArray())
        }, PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id")))
    }

    override fun findById(id: Long): Country? {
        val c = countryRepository.findById(id).get()
        return c
    }

    override fun updateObj(id: Long, t: Country): Country? {
        val country = countryRepository.findById(id).get()

        utilService.bindProperties(t, country, exclude = listOf("id", "cities", "hotels"))

        country.cities?.clear()
        country.cities?.addAll(country.cities?: listOf())

        return countryRepository.save(country)
    }

    fun beforeUpdate(t: Country) {
        if (t.country.isEmpty() || t.country.isBlank()) {
            throw NullPointerException("Country cannot be empty!")
        }
        for (country in countryRepository.findAll()) {
            if (t.country == country.country) {
                throw IllegalStateException("Unable to update to ${t.country}! Existed data found!")
            }
        }
    }

    fun afterUpdate(id: Long) {
        val c = countryRepository.findById(id).get()
        c.updated = Date()
        c.version = c.version!! + 1
        countryRepository.save(c)
    }
}