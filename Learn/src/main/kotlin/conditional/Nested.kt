package conditional

import java.util.Scanner

// Write a program to calculation tax of people base on their gender and salary
fun main() {
    val sc = Scanner(System.`in`)

    print("Input name: ")
    val name = sc.nextLine()

    print("Input gender(M/F): ")
    val gender = sc.nextLine()

    print("Input salary(USD): ")
    val sal = sc.nextFloat()

    var tax = 0f
    var lastSal = 0f
    var hasTax = true

    when (gender.lowercase()) {
        "m" -> {
            if (sal >= 300) {
                tax = sal * 0.1f
                lastSal = sal - tax
            }
            else if (sal >= 200) {
                tax = sal * 0.05f
                lastSal = sal - tax
            }
            else {
                hasTax = false
            }
        }
        else -> {
            if (sal >= 300) {
                tax = sal * 0.05f
                lastSal = sal - tax
            }
            else if (sal >= 250) {
                tax = sal * 0.03f
                lastSal = sal - tax
            }
            else {
                hasTax = false
            }
        }
    }

    when(gender.lowercase()) {
        "m" -> {
            if (hasTax) {
                println(
                    "Hi Mr.${name}, based on your given information, the tax salary that you need to pay is: $tax USD.\n" +
                            "Final salary to received is: $sal - $tax = $lastSal $"
                )
            }
            else {
                println("Hi Mr.${name}, based on your given information, you don't need to pay tax")
            }
        }
        else -> {
            if (hasTax) {
                println(
                    "Hi Mrs.${name}, based on your given information, the tax salary that you need to pay is: $tax USD.\n" +
                            "Final salary to received is: $sal - $tax = $lastSal $"
                )
            }
            else {
                println("Hi Mrs.${name}, based on your given information, you don't need to pay tax")
            }
        }
    }

    sc.close()
}