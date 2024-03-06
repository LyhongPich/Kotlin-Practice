package exception

import java.util.InputMismatchException
import java.util.Scanner

fun main() {
    println("Valid number checking on positive only")

    val sc = Scanner(System.`in`)

    while (true) {
        print("Input number: ")
        try {
            val num = sc.nextInt()

            if (num < 0) {
                throw NegativeNumberException("Negative")
            }

            println("Number is: $num")
            break
        }
        catch (e: InputMismatchException) {
            println("Error: You are inputting non-number value")
            sc.next()
        }
        catch (e: NegativeNumberException) {
            println("Error: ${e.message} value not allowed")
        }
    }



    sc.close()
}