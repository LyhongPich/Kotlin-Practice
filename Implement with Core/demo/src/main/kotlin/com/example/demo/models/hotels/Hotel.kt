package com.example.demo.models.hotels

import com.example.demo.models.city.City
import com.example.demo.models.country.Country
import com.example.demo.models.image.Image
import com.ig.core_backend.core.BaseEntity
import jakarta.persistence.*
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "hotels", uniqueConstraints = [UniqueConstraint(columnNames = ["hotel"])])
data class Hotel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?=null,

    @NotNull
    @Column(length = 100)
    var hotel: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryid")
    var country: Country?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityid")
    var city: City?,

    var stars: Int?,
    var cost: Double?,
    var info: String?,

    @OneToMany(
        targetEntity = Image::class, cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY, orphanRemoval = true
    )
    @JoinColumn(name = "hotelid")
    var images: MutableList<Image>? = null
): BaseEntity() {
    init {
        if (stars !in 0..5) {
            throw IllegalArgumentException("Star should be in between 0 to 5 only")
        }
    }
}
