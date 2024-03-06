import structure.Person

fun main(args: Array<String>) {
    println("Hello World!")

    val person = Person()
    person.name = "John"
    person.gender = "Male"
    person.age = 23

    println("Name: ${person.name}")
    println("Gender: ${person.gender}")
    println("Age: ${person.age}")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}