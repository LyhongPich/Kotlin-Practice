package conditional

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    print("Input first number: ")
    val num1 = sc.nextInt()

    print("Input second number: ")
    val num2 = sc.nextInt()

    // Choice 1
//    if (num1 > num2) {
//        println("$num1 is bigger than $num2")
//    }
//    else {
//        println("$num1 is smaller than $num2")
//    }

    // Choice 2
    val output = if (num1 > num2) "$num1 is bigger than $num2" else "$num1 is smaller than $num2"

    print(output)

    sc.close()
}