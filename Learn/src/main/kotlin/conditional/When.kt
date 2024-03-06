package conditional

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    println("We have food options here:")
    println("1. Fish")
    println("2. Meat")
    println("3. No need")
    print("Your choice: ")
    val num = sc.nextInt()

    when (num) {
        1 -> println("You have choose fish today")
        2 -> println("You have choose meat today")
        else -> {
            println("You don't need anything today")
        }
    }


    sc.close()
}