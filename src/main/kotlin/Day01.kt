fun main() {
    val inputs = readIntegers("input01.txt").toMutableList()

    //  part 1
    /*
    var count = 0
    var previous = inputs.removeFirst()

    inputs.forEach { current ->
        if (current > previous) count++
        previous = current
    }

    println(count)
     */

    //  part 2
    var count = 0
    var previous = 0

    while (true) {
        try {
            if (previous == 0) {
                previous = inputs.component1() + inputs.component2() + inputs.component3()
            } else {
                val current = inputs.component1() + inputs.component2() + inputs.component3()
                if (current > previous) count++
                previous = current
            }
            inputs.removeFirst()
        } catch (e: IndexOutOfBoundsException) {
            break
        }
    }
    println(count)
}