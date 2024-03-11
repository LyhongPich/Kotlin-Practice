package classObject

data class School(val name: String, val type: String)

fun info(school: School) {
    println("${school.name} is the ${school.type} school")
}

fun main() {

    val s = School("ITC", "Engineering")
    info(s)
}