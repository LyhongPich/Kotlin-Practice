package dataStructure.stack

import java.util.Stack

// LIFO or FILO algorithm

fun main() {
    val stack = Stack<Int>()

    for (i in 1..10) {
        stack.push(i)
    }

    for (i in stack.indices) {
        println("Number: ${stack.pop()}")
    }
}