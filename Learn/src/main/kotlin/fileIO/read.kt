package fileIO

import structure.Person
import java.io.File

val people = mutableListOf<Person>()

fun getPerson(line: String) {
    if (line.isNotBlank() && !line.startsWith("Name")) {
        val parts = line.split("\t\t")

        val person = Person()
        person.name = parts[0]
        person.gender = parts[1]
        person.age = parts[2].toInt()

        people.add(person)
    }
}

fun main() {

    val fileName = "./src/main/kotlin/fileIO/test.txt"

    if (File(fileName).exists()) {
        val file = File(fileName)

        file.forEachLine {
            line -> if(line.isNotBlank() && !line.startsWith("Name")) {
                val parts = line.split("\t\t")

                val person = Person()
                person.name = parts[0]
                person.gender = parts[1]
                person.age = parts[2].toInt()

                people.add(person)
            }
        }
    }

    if (people.isNotEmpty()) {
        println("Name\t\tGender\t\tAge")
        for (p in people) {
            println("${p.name}\t\t${p.gender}\t\t${p.age}")
        }
    }
    else {
        println("No record:)")
    }
}