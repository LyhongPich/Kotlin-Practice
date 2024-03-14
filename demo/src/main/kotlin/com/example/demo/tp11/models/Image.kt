package com.example.demo.tp11.models

import jakarta.persistence.*

@Entity
@Table(name = "images")
data class Image(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int?,

        @ManyToOne
        @JoinColumn(name = "hotel_id")
        val hotel: Hotel,

        @Column(length = 256)
        val image_path: String
)
