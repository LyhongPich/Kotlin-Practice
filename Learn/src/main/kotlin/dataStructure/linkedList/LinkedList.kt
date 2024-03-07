package dataStructure.linkedList

import java.util.LinkedList
// Linked-list of java library grant usage for both singly and doubly linked-list

fun main() {
    val list = LinkedList<Int>()

    list.add(4)
    list.add(5)
    list.add(10)
    list.add(12)
    println("After adding data to list: ")
    for (i in list) {
        println("Number: $i")
    }

    val num = 1
    if (list.contains(num)) {
        list.remove(num)
        println("\nAfter removing data from list: ")
        for (i in list) {
            println("Number: $i")
        }
    }
    else {
        println("\n$num is not found in list! Unable to delete")
    }


}