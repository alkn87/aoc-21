package test.kotlin

import day04.Day04
import day04.GameboardReader
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import readInputAsString

class Day04Test {

    private lateinit var day04TestInput: String
    private lateinit var gameboardReader: GameboardReader

    @BeforeEach
    fun setup() {
        day04TestInput = readInputAsString("src/test/resources/day04test_input.txt")
        gameboardReader = GameboardReader()
    }

    @Test
    fun shouldGetResultPart1() {
        val day04 = Day04()
        val day04TestInputList = readInputAsString("src/test/resources/day04test_input.txt")
        assertEquals(4512, day04.part1(day04TestInputList))
    }

    @Test
    fun shouldGetResultPart2() {
        val day04 = Day04()
        val day04TestInputList = readInputAsString("src/test/resources/day04test_input.txt")
        assertEquals(1924, day04.part2(day04TestInputList))
    }

    @Test
    fun shouldParseGameboards() {
        gameboardReader.parseGameBoards(day04TestInput)

        assertEquals(22, gameboardReader.gameBoardList[0].getValue(Pair(0,0)).value)
        assertEquals(7, gameboardReader.gameBoardList[0].getValue(Pair(2,4)).value)
        assertEquals(3, gameboardReader.gameBoardList[2].getValue(Pair(4,3)).value)
    }

    @Test
    fun shouldParseWinningNumbers() {
        gameboardReader.parseWinningNumbers(day04TestInput)
        assertEquals(4, gameboardReader.winningNumbers[1])
        assertEquals(1, gameboardReader.winningNumbers.last())
    }

    @Test
    fun shouldCalculateWinningScore() {
        gameboardReader.parseGameBoards(day04TestInput)
        gameboardReader.parseWinningNumbers(day04TestInput)
        gameboardReader.processWinningNumbers()
        assertEquals(4512, gameboardReader.winningScore)
    }

    @Test
    fun shouldMarkWinningNumbersInBoard() {
        gameboardReader.parseGameBoards(day04TestInput)
        gameboardReader.parseWinningNumbers(day04TestInput)
        gameboardReader.calculateScoreForLastWinningBoard()
        assertEquals(1924, gameboardReader.winningScore)
    }

}
