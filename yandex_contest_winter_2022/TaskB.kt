package ru.gustavo.yandex_2023

fun main() {
    val contains = mutableListOf<Int>()
    val count = readLine()?.toInt()
    if (count != null) {
        val i = if (count % 2 == 0) (count / 2) - 1 else count / 2
        repeat(count) {
            val input = readLine()?.replaceBefore(" ", "")?.trim()?.split(" ")
            if (input != null) {
                val maxSize = input.maxBy { it.toInt() }.toInt()
                contains.add(maxSize)
            }
        }
        contains.sort()
        println(contains[i])
    }
}