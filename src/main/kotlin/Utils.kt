import java.io.File

fun readIntegers(fileName: String): List<Int> =
    File(ClassLoader.getSystemResource(fileName).file).readLines().map { it.toInt() }

fun readLines(fileName: String): List<String> =
    File(ClassLoader.getSystemResource(fileName).file).readLines()