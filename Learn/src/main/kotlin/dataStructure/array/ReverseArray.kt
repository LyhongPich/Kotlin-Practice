package dataStructure.array

fun main() {
    val arr1 = arrayOf(12, 34, 50, 10, 20, 23)

    for (i in arr1.indices) {
        println("Reverse array: ${arr1[arr1.size-1-i]}")
    }
}