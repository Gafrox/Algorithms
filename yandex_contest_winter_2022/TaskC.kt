package ru.gustavo.yandex_2023

fun main() {
    var result = -1
    val input = readLine()?.split(" ")?.map { it.toInt() }
    if (input != null) {
        val cityCount = input[0]
        val roadCount = input[1]
        val roadMap = mutableMapOf<Int, Int>()
        val roadList = mutableListOf<Int>()

        repeat(roadCount) {
            val roads = readLine()?.split(" ")?.map { it.toInt() }
            if (roads != null) {
                roadMap[roads[0]] = roads[1]
                roadList.addAll(roads)
            }
        }
        val roadSet = roadList.toSortedSet()
        var count = 1
        for (i in roadSet) {
            for (j in roadList) {
                if (i.equals(j)) {
                    count++
                }
            }
            if (count == cityCount) {
                result = i
                break
            } else {
                result = -1
                count = 1
            }
        }
        val te = roadMap.keys.toSet()
        val we = roadMap.values.toSet()
        if (te.size == 1 || we.size == 1) {
            if (te.contains(result) || we.contains(result)) {
                result
            }
        } else result = -1
    }
    println(result)
}