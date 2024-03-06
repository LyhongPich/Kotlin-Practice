package dataStructure.array

fun main() {
    val arr1 = arrayOf(12)

    var check = 0
    var count = 1
    print("Leader array: ")
    for (i in arr1.indices) {
        if (i == 0 && arr1.size > 1) {
            if (arr1[i] > arr1[i+1]) {
                print(arr1[i])
            }
            else {
                check = 1
            }
        }
        else if (i < arr1.size-1) {
            if (arr1[i] > arr1[i+1]) {
                if (arr1[i] > arr1[i-1]) {
                    if (check == 0) {
                        print(", ${arr1[i]}")
                    }
                    else {
                        if (count == 1) {
                            print(arr1[i])
                            count = 0
                        }
                        else {
                            print(", ${arr1[i]}")
                        }
                    }
                }
            }
        }
        else {
            print(", ${arr1[i]}")
        }
    }
}