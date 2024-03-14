package com.example.demo.tp11.models

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "users", uniqueConstraints = [UniqueConstraint(columnNames = ["username"])])
data class User(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int?,

        @NotNull
        @Column(length = 30)
        val username: String,

        @Column(length = 80)
        val pass: String,
        val email: String,

        @ManyToOne
        @JoinColumn(name = "role_id")
        val role: Role,

        val discount: Int,

        @Column(length = 256)
        val avatar: String
) {
    init {
        if (username.length < 3) {
            throw IllegalArgumentException("Username too short!")
        }
        if (pass.length < 3) {
            throw IllegalArgumentException("Password too short!")
        }

        if (discount < 0 || discount > 100) {
            throw IllegalArgumentException("Invalid discount amount!")
        }
    }
}
