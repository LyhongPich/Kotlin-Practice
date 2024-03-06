package classObject

import java.util.Scanner

open class Vehicle {
    var model = ""
    var brand = ""
    var year = 0
}

class Moto: Vehicle() {
    fun info() {
        println("This moto is ${brand}(brand) from ${model}(model) first built in $year")
    }
}

fun main() {
    val moto = Moto()

    val sc = Scanner(System.`in`)

    print("Input moto model: ")
    moto.model = sc.nextLine()

    print("Input moto brand: ")
    moto.brand = sc.nextLine()

    print("Input built year: ")
    moto.year = sc.nextInt()

    println("\t\t\tInformation")
    moto.info()

    sc.close()
}