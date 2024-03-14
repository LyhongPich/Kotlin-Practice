package com.example.demo.tp11.models

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "hotels")
data class Hotel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int?,

        @Column(length = 100)
        @NotNull
        val hotel: String,

        @ManyToOne
        @JoinColumn(name = "country_id")
        val country: Country,

        @ManyToOne
        @JoinColumn(name = "city_id")
        val city: City,

        val stars: Int,
        val cost: Double,
        val info: String
) {
        init {
            if (stars < 0 || stars > 5) {
                    throw IllegalArgumentException("Column star must have value between 0 to 5!")
            }
        }
}
