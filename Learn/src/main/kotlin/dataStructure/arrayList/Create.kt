package dataStructure.arrayList

fun main() {
    val arr = ArrayList<Int>()
    println("ArrayList initial size: ${arr.size}")

    arr.add(2)
    arr.add(5)

    println("Original ArrayList: ")
    for (i in arr) {
        println("Number: $i")
    }

    arr.addAll(arr)
//    arr.addAll(arrayOf(10, 12, 11))
    println("\nUpdate ArrayList: ")

    for (i in arr) {
        println("Number: $i")
    }
}