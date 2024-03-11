package classObject.abstracts

abstract class Animal(val species: String, val age: Int, val habitat: String) {
    abstract fun move()
    abstract fun eat()
}