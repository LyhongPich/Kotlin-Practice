package dataStructure

// Datatype can be in "<>"
class Stack<T> {
    private val element: MutableList<T> = mutableListOf()

    fun push(item: T) {
        element.add(item)
    }

    fun pop(): T? {
        if (element.isEmpty()) {
            return null
        }
        return element.removeAt(element.size-1)
    }

    fun peek(): T?   {
        return element.lastOrNull()
    }

}

fun main() {

}
