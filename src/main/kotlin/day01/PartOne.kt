package day01

import java.io.File

class PartOne(
    private val input: String = File("src/main/kotlin/day01/input.txt").readText()
) {

    fun solve(): Int {
        return input.lines().sumOf {
            it.transform()
        }
    }

    private fun String.transform(): Int = "${first { it.isDigit() }}${last { it.isDigit() }}".toInt()
}

fun main() {
    val solver = PartOne()
    println(solver.solve()) // 53080
}