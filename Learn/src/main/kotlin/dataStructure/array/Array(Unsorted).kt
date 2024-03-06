package dataStructure.array

fun main() {

    // Various data types or same data type
    val arr1 = arrayOf(12, 34, 50, 10, 20, 23)

    // Specific data type (not available for string)
    val arr2 = intArrayOf(3, 50, 10, 12)
    val arr3 = charArrayOf('s', 'a', 'g', 'h')

    // Specific size array with default value
    val arr4 = IntArray(5)
    val arr5 = IntArray(5) { 10 }

    // Specific size array with custom initialize value
    val arr6 = Array(5) { it }
    val arr7 = Array(5) { it*2 }

    println("Array 1(Mix-type): ${arr1.joinToString()}\n")
    println("Array 2(Specific type): ${arr2.joinToString()}\n")
    println("Array 4(Specific size_Default value): ${arr4.joinToString()}\n")
    println("Array 5(Specific size_Customize init_value): ${arr5.joinToString()}\n")

    // Search data and its index in array
    var arr = arr1
    val num = 22

    when (val check = arr.indexOf(num)) {
        -1 -> println("Number $num not found!")
        else -> println("Number $num found at index $check")
    }

    // Insert data
    // Array is fixed in size, so possible way is to remove data then insert new data to it position
    // or make new array with more extend size

    // Insert the last index by replace
    println("\nBefore Insertion Array1: ${arr.joinToString()}")
//    arr1[arr1.size-1] = num
//    println("After Insertion Array1: ${arr1.joinToString()}")

    // Insert any index by replace
//    val pos = 5
//    try {
//        if (pos > arr1.size) {
//            throw IndexOutOfBoundsException()
//        }
//        arr1[pos] = num
//        println("After Insertion Array1: ${arr.joinToString()}")
//    }
//    catch (e: IndexOutOfBoundsException) {
//        println("Index $pos is out of bound for length ${arr.size}")
//    }

    // Copy data to new array then extend the size
//    val newArr = arrayOfNulls<Int>(arr.size+1)
//
//    System.arraycopy(arr, 0, newArr, 0, arr.size)
//
//    newArr[newArr.size-1] = num
//    println("After Insertion New Array: ${newArr.joinToString()}")

    // Delete data in array
    val deleteData = 15
    when (val check = arr.indexOf(deleteData)) {
        -1 -> println("$deleteData not found! No data to delete")
        else -> {
            arr = arr.filter { it != deleteData }.toTypedArray()
            println("After Deletion Array: ${arr.joinToString()}")
        }
    }
}