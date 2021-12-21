import day04.BoardItem
import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(fileName: String) = File(fileName).readLines().map { it.trim() }

/**
 * Reads a complete string from input file
 */
fun readInputAsString(fileName: String) = File(fileName).readText()

/**
 * Reads a complete string from input file and returns a board with a grid of [BoardItem]
 */
fun asGrid(input: String): HashMap<Pair<Int, Int>, BoardItem> {
    mutableListOf<List<BoardItem>>()
    val grid = HashMap<Pair<Int, Int>, BoardItem>()
    input.split("\n").filter { it.isNotBlank() }
        .forEachIndexed { rowIndex, row ->
            row.trim().split(" +".toRegex())
                .forEachIndexed { colIndex, col -> grid[Pair(rowIndex, colIndex)] = BoardItem(col.toInt(), false) }
        }
    return grid
}

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
