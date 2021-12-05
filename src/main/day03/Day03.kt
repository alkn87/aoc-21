package day03

import readInput
import java.util.*
import kotlin.math.pow
import kotlin.streams.toList

fun main() {
    val tag = "day03"
    val day03 = Day03()
    println(tag)
    println(day03.part1(readInput("src/main/resources/day03_input.txt")))
    println(day03.part2(readInput("src/main/resources/day03_input.txt")))
}

class Day03 {

    private val dataHolder = BitDataHolder(0, 0)
    private var maxIndex = 0

    fun part1(input: List<String>): Long {
        input.forEach { parseBits(it) }
        val range = IntRange(0, dataHolder.maxIndex)
        val oneBits =
            range.mapIndexed { index, _ -> dataHolder.bitStream.stream().filter { it.get(index) }.count() }.toList()
                .reversed()
        val zeroBits = oneBits.map { dataHolder.bitStream.size - it }.toList()
        val gammaRateBitSet = BitSet(dataHolder.maxIndex + 1)
        oneBits.mapIndexed { index, value -> value > zeroBits[index] }
            .forEachIndexed { index, bool -> gammaRateBitSet.set(index, bool) }
        val epsilonRateBitSet = gammaRateBitSet[0, dataHolder.maxIndex + 1]
        IntRange(0, dataHolder.maxIndex).forEachIndexed { index, _ ->
            epsilonRateBitSet.set(
                index,
                !epsilonRateBitSet.get(index)
            )
        }
        val gammaRate = gammaRateBitSet.stream().mapToDouble { 2.0.pow(it) }.sum()
        val epsilonRate = epsilonRateBitSet.stream().mapToDouble { 2.0.pow(it) }.sum()
        return Math.multiplyExact(gammaRate.toLong(), epsilonRate.toLong())
    }

    fun part2(input: List<String>): Int {
        val bitSetStream = parseBitsToBitSet(input)
        val oxygenRating = getEntriesWithBitCriteria(0, true, bitSetStream, "most")
        println(oxygenRating)
        val scrubberRating = getEntriesWithBitCriteria(0, true, bitSetStream, "least")
        println(scrubberRating)
        return oxygenRating * scrubberRating
    }

    private fun parseBits(inputLine: String) {
        dataHolder.numberOfLines++
        val bitSet = BitSet(inputLine.length)
        dataHolder.maxIndex =
            if (inputLine.length - 1 > dataHolder.maxIndex) inputLine.length - 1 else dataHolder.maxIndex
        inputLine.forEachIndexed { index, bit -> bitSet.set(index, bit == '1') }
        dataHolder.bitStream.add(bitSet)
    }

    fun parseBitsToBitSet(input: List<String>): List<BitSet> {
        val bitSetStream = mutableListOf<BitSet>()
        input.forEach {
            maxIndex = if (it.length - 1 > maxIndex) it.length - 1 else maxIndex
            println(maxIndex)
            val bitSet = BitSet(it.length)
            it.forEachIndexed { index, bit ->
                bitSet.set(index, bit == '1')
            }
            bitSetStream.add(bitSet)
        }
        return bitSetStream
    }

    private fun getMostCommonBit(input: List<BitSet>, position: Int, tieBreaker: Boolean): Boolean {
        val oneBit = input.count { it.get(position) }
        val zeroBit = input.count { !it.get(position) }
        return if (tieBreaker) {
            oneBit >= zeroBit
        } else {
            oneBit > zeroBit
        }
    }

    private fun getLeastCommonBit(input: List<BitSet>, position: Int, tieBreaker: Boolean): Boolean {
        val oneBit = input.count { it.get(position) }
        val zeroBit = input.count { !it.get(position) }
        return if (!tieBreaker) {
            zeroBit >= oneBit
        } else {
            zeroBit > oneBit
        }
    }

    fun getEntriesWithBitCriteria(startIndex: Int, tieBreaker: Boolean, input: List<BitSet>, criteria: String): Int {
        var bitCriteria = false
        if (criteria == "most") {
            bitCriteria = getMostCommonBit(input, startIndex, tieBreaker)
        } else if (criteria == "least") {
            bitCriteria = getLeastCommonBit(input, startIndex, tieBreaker)
        }

        if (input.size > 1) {
            val subInput =
                input.stream().filter { it.get(startIndex) == bitCriteria }.toList()
            println(subInput)
            return getEntriesWithBitCriteria(startIndex + 1, tieBreaker, subInput, criteria)
        }

        println("${input[0]} ::: $criteria ::: $bitCriteria")
        return input[0].stream().mapToDouble { 2.0.pow(maxIndex - it) }.sum().toInt()

    }
}
