package loop

fun main() {
    val fruits = mutableListOf("Apple", "Banana", "Orange")

    var count = 1
    for (fruit in fruits) {
        println("Item ${count}: $fruit")
        count++
    }

    for (i in fruits.indices) {
        println("Item ${i}: ${fruits[i]}")
    }
}