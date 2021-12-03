package day02

import readInput

fun main() {
    val tag = "Day02"
    val day02 = Day02()
    println(tag)
    println(day02.part1(readInput("src/main/resources/day02_input.txt")))
    println(day02.part2(readInput("src/main/resources/day02_input.txt")))
}

class Day02 {

    private val position = Position(0, 0)
    private val aimPosition = AimPosition(0, 0, 0)

    fun part1(input: List<String>): Int {
        input.forEach {
            position.move(parseCommand(it))
        }

        return position.depth * position.horizontal
    }

    fun part2(input: List<String>): Int {
        input.forEach{
            aimPosition.move(parseCommand(it))
        }
        return aimPosition.depth * aimPosition.horizontal
    }

    private fun parseCommand(input: String): Pair<String, Int> {
        val command = input.split(" ")
        return Pair(command[0], command[1].toInt())
    }
}


