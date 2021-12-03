package test.kotlin

import day01.Day01
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import readInput

class Day01Test {

    @Test
    fun shouldGiveExplanationResultPart1() {
        val day01 = Day01()
        val day01TestInput = readInput("src/test/resources/day01test_input.txt")
        assertEquals(7, day01.part1(day01TestInput))
    }

    @Test
    fun shouldGiveExplanationResultPart2() {
        val day01 = Day01()
        val day01TestInput = readInput("src/test/resources/day01test_input.txt")
        assertEquals(5, day01.part2(day01TestInput))
    }
}
