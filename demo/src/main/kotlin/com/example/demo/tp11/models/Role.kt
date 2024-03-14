package com.example.demo.tp11.models

import jakarta.persistence.*

@Entity
@Table(name = "roles", uniqueConstraints = [UniqueConstraint(columnNames = ["role"])])
data class Role(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int?,

        @Column(length = 20)
        val role: String
)
