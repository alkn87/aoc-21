package day02

open class Position(var horizontal: Int, var depth: Int) {

    open fun move(command: Pair<String, Int>) {
        when (command.first) {
            "forward" -> horizontal += command.second
            "down" -> depth += command.second
            "up" -> depth -= command.second
        }
    }

}
