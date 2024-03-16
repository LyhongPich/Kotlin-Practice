package com.example.demo.tp11.response

data class APIResponse<T>(
    val recordCount: Int,
    val response: T
)
