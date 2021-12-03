package day01

import readInput
import kotlin.streams.toList

fun main() {
    val tag = "Day01"
    val day01 = Day01()
    println(tag)
    println(day01.part1(readInput("src/main/resources/day01_input.txt")))
    println(day01.part2(readInput("src/main/resources/day01_input.txt")))
}

class Day01 {

    fun part1(input: List<String>): Int {
        return input.windowed(2, 1, false).stream()
            .filter { it[1].toInt() > it[0].toInt() }.count().toInt()
    }

    fun part2(input: List<String>): Int {
        return input.windowed(3, 1, false).stream()
            .toList().windowed(2, 1, false).stream()
            .filter { pairWindow -> pairWindow[1].sumOf { it.toInt() } > pairWindow[0].sumOf { it.toInt() } }
            .count().toInt()
    }
}


