fun main() {
    val inputs = readIntegers("input01.txt").toMutableList()

    var count = 0
    var previous = inputs.removeFirst()

    inputs.forEach { current ->
        if (current > previous) count++
        previous = current
    }

    println(count)
}