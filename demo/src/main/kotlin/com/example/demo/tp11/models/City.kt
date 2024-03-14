package com.example.demo.tp11.models

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "cities", uniqueConstraints = [UniqueConstraint(columnNames = ["ucity"])])
data class City(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int?,

        @Column(length = 50)
        @NotNull
        val city: String,

        @ManyToOne
        @JoinColumn(name = "country_id")
        val country: Country,

//        @OneToMany(mappedBy = "city", cascade = [CascadeType.ALL])
//        val hotels: List<Hotel>,

        @Column(length = 60)
        val ucity: String = "${city}_${country.id}"
) {
        init {
            if (!ucity.startsWith("${city}_")) {
                    throw IllegalArgumentException("Ucity format invalid!\n")
            }
        }
}
