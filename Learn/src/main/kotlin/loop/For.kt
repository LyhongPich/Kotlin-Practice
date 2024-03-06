package loop

import java.util.Scanner

// Write a program to do summation and multiplication from starting number to ending number
fun main() {
    val sc = Scanner(System.`in`)

    print("Input starting number: ")
    var st = sc.nextInt()

    print("Input ending number: ")
    var en = sc.nextInt()

    var sum = 0
    var prod = 1

    if (st > en) {
        var tmp = st
        st = en
        en = tmp
    }

    // Summation calculation
    print("Summation: ")
    for (i in st..en) {
        if (i == st) {
            print(i)
        }
        else {
            print("+$i")
        }
        sum+=i
    }
    print("=$sum\n")

    if (st == 0 || en == 0) {
        prod*=0
        print("Since either starting number or ending number is 0\nMultiplication: $prod")
        return
    }
    // Multiplication calculation
    print("Multiplication: ")
    for (i in st..en) {
//        if (st == 0 || en == 0) {
//            prod *= 0
//            break
//        }
        if (i == st) {
            print(i)
        }
        else {
            print("*$i")
        }
        prod*=i
    }
    print("=$prod")

    sc.close()
}