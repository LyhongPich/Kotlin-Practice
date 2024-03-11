package classObject.polymorphism

// Dynamic polymorphism (Runtime polymorphism) for overriding method

open class Shape {
    open fun draw(){
        println("Drawing shape")
    }
}

class Circle: Shape() {
    override fun draw() {
        println("Drawing circle")
    }
}

class Square: Shape() {
    override fun draw() {
        println("Drawing square")
    }
}

fun main() {
    val shape = Shape()
    val circle = Circle()
    val square = Square()

    shape.draw()
    circle.draw()
    square.draw()
}