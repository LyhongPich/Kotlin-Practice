package com.example.demo.tp11.models

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "countries", uniqueConstraints = [UniqueConstraint(columnNames = ["country"])])
data class Country(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int?,

        @Column(length = 50)
        @NotNull
        var country: String,

        @OneToMany(mappedBy = "country", cascade = [CascadeType.ALL])
        var cities: List<City>? = null,

        @OneToMany(mappedBy = "country", cascade = [CascadeType.ALL])
        var hotels: List<Hotel>? = null
)
