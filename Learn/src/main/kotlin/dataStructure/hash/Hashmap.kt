package dataStructure.hash


fun main() {
    val hashmap = HashMap<String, Int>()

    for (i in Number.entries) {
        hashmap[i.toString()] = i.ordinal+1
    }

    for (i in hashmap) {
        println(i)
    }
}