package day04

import asGrid

class GameboardReader {

    val gameBoardList = mutableListOf<HashMap<Pair<Int, Int>, BoardItem>>()
    val winningNumbers = mutableListOf<Int>()
    var winningScore = 0

    fun parseGameBoards(input: String) {
        gameBoardList.clear()
        var listOfRawStrings = input.split("\n\r")

        listOfRawStrings = listOfRawStrings.subList(1, listOfRawStrings.lastIndex + 1)
        listOfRawStrings.forEach { gameBoardList.add(asGrid(it)) }
    }

    fun parseWinningNumbers(input: String) {
        winningNumbers.clear()
        val listOfRawStrings = input.split("\n\r")
        listOfRawStrings[0].trim().split(",").forEach { winningNumbers.add(it.toInt()) }
    }

    fun processWinningNumbers() {
        winningNumbers.forEach { winningNumber ->
            if (winningScore > 0) return@forEach
            gameBoardList.forEach { board ->
                if (winningScore > 0) return@forEach
                board.filter { (_, value) -> value.value == winningNumber }.entries.forEach { it.value.marked = true }
                if (checkColWon(board) || checkRowWon(board)) {
                    calculateWinningScore(winningNumber, board)
                }
            }
        }
    }

    fun calculateScoreForLastWinningBoard() {
        val winningsBoards = mutableSetOf<Int>()
        winningNumbers.forEach { winningNumber ->
            gameBoardList.forEachIndexed { boardIndex, board ->
                board.filter { (_, value) -> value.value == winningNumber }.entries.forEach { it.value.marked = true }
                if ((checkColWon(board) || checkRowWon(board)) && !winningsBoards.contains(boardIndex)) {
                    calculateWinningScore(winningNumber, board)
                    winningsBoards.add(boardIndex)
                }
            }
        }
    }

    private fun calculateWinningScore(winningNumber: Int, board: HashMap<Pair<Int, Int>, BoardItem>) {
        winningScore = winningNumber * board.filter { !it.value.marked }.values.sumOf { it.value }
    }

    private fun checkColWon(board: HashMap<Pair<Int, Int>, BoardItem>): Boolean {
        (0..4).forEach { colIndex ->
            val won = (0..4).all { board[Pair(it, colIndex)]?.marked ?: false }
            if (won) return true
        }
        return false
    }

    private fun checkRowWon(board: HashMap<Pair<Int, Int>, BoardItem>): Boolean {
        (0..4).forEach { rowIndex ->
            val won = (0..4).all { board[Pair(rowIndex, it)]?.marked ?: false }
            if (won) return true
        }
        return false
    }
}
