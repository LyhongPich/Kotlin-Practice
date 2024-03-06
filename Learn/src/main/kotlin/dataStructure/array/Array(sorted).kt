package dataStructure.array

fun main() {
    var arr1 = arrayOf(12, 34, 50, 10, 20, 23)

    println("Before sorting: ${arr1.joinToString()}")

    arr1.sort()
//    arr1.sortWith(Comparator { a, b -> b-a })

    println("After sorting: ${arr1.joinToString()}")
}