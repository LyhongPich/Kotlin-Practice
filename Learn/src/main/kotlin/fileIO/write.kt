package fileIO

import structure.Person
import java.io.File
import java.io.FileWriter
import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val person = Person()

    print("Input your name: ")
    person.name = sc.nextLine()

    print("Input your gender: ")
    person.gender = sc.nextLine()

    print("Input your age: ")
    person.age = sc.nextInt()

    val fileName = "./src/main/kotlin/fileIO/test.txt"

    val header = File(fileName).exists()
    val file = FileWriter(fileName, header)

    if(!header) {
        file.write("Name\t\tGender\t\tAge\n")
    }

    file.write("${person.name}\t\t${person.gender}\t\t${person.age}\n")
    file.close()

    sc.close()
}