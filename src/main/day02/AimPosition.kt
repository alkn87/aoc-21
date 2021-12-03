package day02

class AimPosition(horizontal: Int, depth: Int, var aim: Int) : Position(horizontal, depth) {

    override fun move(command: Pair<String, Int>) {
        when (command.first) {
            "forward" -> {
                horizontal += command.second
                depth += command.second * aim
            }
            "down" -> aim += command.second
            "up" -> aim -= command.second
        }
    }

}
