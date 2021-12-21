package day04

import readInputAsString

fun main() {
    val tag = "day04"
    val day04 = Day04()
    val day04Input = readInputAsString("src/main/resources/day04_input.txt")

    println(tag)
    println(day04.part1(day04Input))
    println(day04.part2(day04Input))
}

class Day04 {

    val gameboardReader = GameboardReader()

    fun part1(input: String): Int {
        gameboardReader.parseGameBoards(input)
        gameboardReader.parseWinningNumbers(input)
        gameboardReader.processWinningNumbers()

        return gameboardReader.winningScore
    }

    fun part2(input: String): Int {
        gameboardReader.parseGameBoards(input)
        gameboardReader.parseWinningNumbers(input)
        gameboardReader.calculateScoreForLastWinningBoard()

        return gameboardReader.winningScore
    }
}
