fun main() {

    part1()

    part2()
}

private fun part1() {
    var horizontal = 0
    var depth = 0

    readLines("input02.txt").map { input ->
        Pair(
            input.split(" ")[0],
            input.split(" ")[1].toInt()
        )
    }.forEach { course ->
        when (course.first) {
            "forward" -> horizontal += course.second
            "up" -> depth -= course.second
            "down" -> depth += course.second
        }
    }
    println(horizontal * depth)
}

private fun part2() {
    var horizontal = 0
    var depth = 0
    var aim = 0

    readLines("input02.txt").map { input ->
        Pair(
            input.split(" ")[0],
            input.split(" ")[1].toInt()
        )
    }.forEach { course ->
        when (course.first) {
            "forward" -> {
                horizontal += course.second
                depth += course.second * aim
            }
            "up" -> {
                aim -= course.second
            }
            "down" -> {
                aim += course.second
            }
        }
    }
    println(horizontal * depth)
}