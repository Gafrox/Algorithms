package ru.gustavo.yandex_2023

fun main() {
    val input = readLine()?.split(" ")?.map { it.toInt() }
    val width = input!![0]
    val numbers = input[1]
    val lengths = readLine()?.split(" ")?.map { it.toInt() }
    val sum = lengths!!.sumOf { it }
    val result = when (width) {
        1 -> sum
        else -> calc(width, lengths, sum)
    }
    println(result)
}

fun calc(w: Int, list: List<Int>, sum: Int): Int {
    var output = IntArray(w) { 0 }
    var extW = sum / w
    while (extW != output.min()) {
        var j = 0
        for (elem in list) {
            if (output[j] < extW) {
                output[j] += elem
            } else if ((j + 1) > (output.size - 1)) {
                output[j] += elem
            } else {
                output[j + 1] += elem
            }
            if (j < (output.size - 1)) {
                j = if (output[j] >= extW) j + 1 else j
            }
        }
        if (extW != output.min()) {
            extW -= 1
            output = IntArray(w) { 0 }
        }
    }
    return output.min()
}