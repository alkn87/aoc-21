package test.kotlin

import day03.Day03
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import readInput

class Day03Test {

    @Test
    fun shouldGiveExplanationResultPart1() {
        val day03 = Day03()
        val day03TestInput = readInput("src/test/resources/day03test_input.txt")
        assertEquals(198, day03.part1(day03TestInput))
    }

    @Test
    fun shouldFindTheMostCommonBitSolution() {
        val day03 = Day03()
        val day03TestInput = readInput("src/test/resources/day03test_input.txt")
        val bitSetStream = day03.parseBitsToBitSet(day03TestInput)
        assertEquals(23, day03.getEntriesWithBitCriteria(0, true, bitSetStream, "most"))
    }

    @Test
    fun shouldFindThLeastCommonBitSolution() {
        val day03 = Day03()
        val day03TestInput = readInput("src/test/resources/day03test_input.txt")
        val bitSetStream = day03.parseBitsToBitSet(day03TestInput)
        assertEquals(10, day03.getEntriesWithBitCriteria(0, true, bitSetStream, "least"))
    }


    @Test
    fun shouldGiveExplanationResultPart2() {
        val day03 = Day03()
        val day03TestInput = readInput("src/test/resources/day03test_input.txt")
        assertEquals(230, day03.part2(day03TestInput))
    }

}
