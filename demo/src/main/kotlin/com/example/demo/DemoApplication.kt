package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

//@RestController
//class MessageController {
//	@GetMapping("/")
//	fun index() = listOf(
//		Message("1", "Bonjour!"),
//		Message("2", "Au révoir"),
//		Message("3", "Merci")
//	)
//}
//
//data class Message(val id: String?, val text: String)
