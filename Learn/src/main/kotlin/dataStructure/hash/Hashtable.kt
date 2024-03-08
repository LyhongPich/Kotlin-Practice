package dataStructure.hash

import java.util.Hashtable

fun main() {

    val hashtable = Hashtable<String, Int>()

    for (i in Number.entries){
        hashtable[i.toString()] = i.ordinal+1
    }
//    println("Hashtable: $hashtable")

    for (i in hashtable) {
        println(i)
    }

}