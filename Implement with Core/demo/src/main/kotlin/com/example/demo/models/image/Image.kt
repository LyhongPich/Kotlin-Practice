package com.example.demo.models.image

import com.example.demo.models.hotels.Hotel
import com.fasterxml.jackson.annotation.JsonIgnore
import com.ig.core_backend.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Entity
@Table(name = "images", uniqueConstraints = [UniqueConstraint(columnNames = ["imagepath"])])
data class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?=null,

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelid", insertable = true, updatable = false, nullable = true)
    var hotel: Hotel?=null,

    @Column(length = 256)
    var imagepath: String,
): BaseEntity()
