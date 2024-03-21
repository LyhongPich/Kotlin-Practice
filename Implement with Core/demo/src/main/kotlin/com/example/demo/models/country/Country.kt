package com.example.demo.models.country

import com.example.demo.models.city.City
import com.example.demo.models.hotels.Hotel
import com.ig.core_backend.core.BaseEntity
import jakarta.persistence.*
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "countries", uniqueConstraints = [UniqueConstraint(columnNames = ["country"])])
data class Country(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?=null,

    @NotNull
    @Column(length = 50)
    var country: String,

    @OneToMany(
        targetEntity = City::class, cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY, orphanRemoval = true
    )
    @JoinColumn(name = "countryid", referencedColumnName = "id")
    var cities: MutableList<City>? = null,
) : BaseEntity()
