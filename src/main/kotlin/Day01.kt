fun main() {
    val inputs = readIntegers("input01.txt").toMutableList()

    part1(inputs)

    part2(inputs)
}

private fun part1(inputs: MutableList<Int>) {
    var count = 0
    var previous = inputs.removeFirst()

    inputs.forEach { current ->
        if (current > previous) count++
        previous = current
    }
    println(count)
}

private fun part2(inputs: MutableList<Int>) {
    var count = 0
    var previous = 0

    while (true) {
        try {
            previous = if (previous == 0) {
                inputs.component1() + inputs.component2() + inputs.component3()
            } else {
                val current = inputs.component1() + inputs.component2() + inputs.component3()
                if (current > previous) count++
                current
            }
            inputs.removeFirst()
        } catch (e: IndexOutOfBoundsException) {
            break
        }
    }
    println(count)
}