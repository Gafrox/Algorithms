package ru.gustavo.yandex_2023

fun main() {
    val firstSymbolList = mutableListOf<Char>()
    val count = readLine()?.toInt()
    count?.let {
        repeat(it) {
            val firstSymbol = readLine()?.first()
            firstSymbolList.add(firstSymbol!!)
        }
    }
    val numbersByElement = firstSymbolList.groupingBy { it }.eachCount()
    println(numbersByElement.maxByOrNull { it.value }?.key)
}