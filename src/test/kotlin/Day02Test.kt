package test.kotlin

import day02.Day02
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import readInput

class Day02Test {

    @Test
    fun shouldGiveExplanationResultPart1() {
        val day02 = Day02()
        val day02TestInput = readInput("src/test/resources/day02test_input.txt")
        assertEquals(150, day02.part1(day02TestInput))
    }

    @Test
    fun shouldGiveExplanationResultPart2() {
        val day02 = Day02()
        val day02TestInput = readInput("src/test/resources/day02test_input.txt")
        assertEquals(900, day02.part2(day02TestInput))
    }
}
