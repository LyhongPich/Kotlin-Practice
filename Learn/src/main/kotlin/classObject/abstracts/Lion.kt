package classObject.abstracts

class Lion(species: String, age: Int, habitat: String): Animal(species,age,habitat) {
    override fun move() {
        println("$species can live up to $age years in ${habitat}.\nIt moves fast.")
    }

    override fun eat() {
        println("$species eats meat for living.")
    }
}

fun main() {
    val lion = Lion("Lion", 9, "jungle")
    lion.move()
    lion.eat()
}