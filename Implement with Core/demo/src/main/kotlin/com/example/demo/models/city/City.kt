package com.example.demo.models.city

import com.example.demo.models.country.Country
import com.example.demo.models.hotels.Hotel
import com.fasterxml.jackson.annotation.JsonIgnore
import com.ig.core_backend.config.gson_config.Exclude
import com.ig.core_backend.core.BaseEntity
import jakarta.persistence.*
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "cities", uniqueConstraints = [UniqueConstraint(columnNames = ["city"])])
data class City(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?=null,

    @NotNull
    @Column(length = 50)
    var city: String,

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryid", insertable = true, updatable = false, nullable = true)
//    @Exclude
    var country: Country?=null,

    @OneToMany(
        targetEntity = Hotel::class, cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY, orphanRemoval = true
    )
    @JoinColumn(name = "cityid")
    var hotels: MutableList<Hotel>? = null,



    val ucity: String = "${city}_${country?.id}"
): BaseEntity()
