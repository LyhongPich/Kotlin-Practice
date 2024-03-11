package classObject.polymorphism

// Static polymorphism (Compile-time polymorphism) for overloading method
fun add(a: Int, b: Int): Int {
    return a+b
}

fun add(a: Double, b: Double): Double {
    return a+b
}

fun add(a: Double, b: Int): Double {
    return a+b
}

fun add(a: Int, b: Double): Double {
    return a+b
}

fun main() {
    println("Result: ${add(5.3,7.5)}")
}