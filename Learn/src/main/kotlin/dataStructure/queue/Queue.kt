package dataStructure.queue

import java.util.LinkedList

// FIFO algorithm
fun main() {

    val queue = LinkedList<Int>()

    queue.add(1)
    queue.add(23)

    for (i in queue.indices) {
        println("FIFO order: ${queue.poll()}")
    }

    println("After done: $queue")
}