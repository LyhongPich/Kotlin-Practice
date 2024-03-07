package dataStructure.linkedList

import kotlin.NullPointerException

class Element<T> {
    var data: T? = null
    var next: Element<T>? = null
}

class List<T> {
    var size: Int? = null
    var head: Element<T>? = null
    var tail: Element<T>? = null

    fun insertToBegin( data: T) {
        val tmp = Element<T>()
        tmp.data = data

        if (size != null) {
            if (size == 0) {
                tmp.next = null
                tail = tmp
            }
            else {
                tmp.next = head
            }
            head = tmp
            size = size!! + 1
        }
        else {
            println("Please initialize an empty list first")
        }
    }

    fun insertToPosition(data: T, pos: Int) {

        if (size != null) {
            val tmp = Element<T>() // Element to be insert
            tmp.data = data
            tmp.next = null

            var track: Element<T>  // Track position to insert
            track = head!!

            if (pos == 1) {
                insertToBegin(data)
            }
            else if (pos in 2..size!!) {
                for (i in 1..<pos) {
                    track = track.next!!
                }
                tmp.next = track.next
                track.next = tmp
                size = size!! + 1
            }
            else if (pos == size!! +1) {
                insertToEnd(data)
            }
            else {
                println("Not possible to add the position: $pos\nError: Out of bound")
            }
        }
        else {
            println("Please initialize an empty list first")
        }
    }
    fun insertToEnd(data: T) {
        val tmp = Element<T>()
        tmp.data = data
        tmp.next = null

        if (size != null) {
            if (size == 0) {
                head = tmp
            }
            else {
                tail?.next = tmp
            }
            tail = tmp
            size = size!! + 1
        }
        else {
            println("Please initialize an empty list first")
        }
    }

    fun displayList() {
        var tmp: Element<T>
        tmp = head!!
        try {
            while (tmp != null) {
                println("${tmp.data} ")
                tmp = tmp.next!!
            }
        }
        catch (e: NullPointerException) {
            // Disable display error on null value
        }

    }

}

fun <T> createList(): List<T> {
    val list = List<T>()
    list.size = 0
    list.head = null
    list.tail = null

    return list
}

fun main() {
    val list = createList<Int>()

    list.insertToBegin(3)
    list.insertToEnd(10)
    list.insertToPosition(25, 3)

    list.displayList()
}