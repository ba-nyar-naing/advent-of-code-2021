fun main() {

    part1()

    part2()
}

private fun part1() {
    val bits = hashMapOf<Int, Int>()

    readLines("input03.txt").map { input ->
        input.forEachIndexed { index, c ->
            if (c == '0') {
                bits[index] = (bits[index] ?: 0) - 1
            } else {
                bits[index] = (bits[index] ?: 0) + 1
            }
        }
    }

    var rateGamma = ""
    var rateEpsilon = ""

    bits.values.forEach { bit ->
        if (bit > 0) {
            rateGamma += "1"
            rateEpsilon += "0"
        } else {
            rateGamma += "0"
            rateEpsilon += "1"
        }
    }

    println(
        Integer.valueOf(rateGamma, 2) * Integer.valueOf(rateEpsilon, 2)
    )
}

private fun part2() {

    val o2 = findO2GeneratorRating(readLines("input03.txt"))
    println(o2)

    val co2 = findCO2ScrubberRating(readLines("input03.txt"))
    println(co2)

    println(o2 * co2)
}

private fun findO2GeneratorRating(inputs: List<String>): Int {
    var count = 0
    var index = 0
    var evenBits = mutableListOf<String>()
    var oddBits = mutableListOf<String>()
    var selectedBits = inputs

    while (index < 12) {
        selectedBits.map { selected ->
            if (selected[index] == '0') {
                count--
                evenBits.add(selected)
            } else {
                count++
                oddBits.add(selected)
            }
        }
        index++
//        println("index=$index, count=$count")

        selectedBits = if (count >= 0) {
            oddBits
        } else {
            evenBits
        }
        evenBits = mutableListOf()
        oddBits = mutableListOf()
        count = 0

//        println(selectedBits)
        if (selectedBits.size == 1) break
    }
    return Integer.valueOf(selectedBits.joinToString(""), 2)
}


private fun findCO2ScrubberRating(inputs: List<String>): Int {
    var count = 0
    var index = 0
    var evenBits = mutableListOf<String>()
    var oddBits = mutableListOf<String>()
    var selectedBits = inputs

    while (index < 12) {
        selectedBits.map { selected ->
            if (selected[index] == '0') {
                count++
                evenBits.add(selected)
            } else {
                count--
                oddBits.add(selected)
            }
        }
        index++
//        println("index=$index, count=$count")

        selectedBits = if (count > 0) {
            oddBits
        } else {
            evenBits
        }
        evenBits = mutableListOf()
        oddBits = mutableListOf()
        count = 0

//        println(selectedBits)
        if (selectedBits.size == 1) break
    }
    return Integer.valueOf(selectedBits.joinToString(""), 2)
}