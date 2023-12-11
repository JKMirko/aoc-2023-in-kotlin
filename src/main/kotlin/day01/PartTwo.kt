package day01

import java.io.File

class PartTwo(
    private val input: String = File("src/main/kotlin/day01/input.txt").readText()
) {

    fun solve(): Int {
        return input.lines().sumOf {
            it.transform()
        }
    }

    private fun String.transform(): Int {
        val mapped = mapIndexed { index, ch ->
            if (ch.isDigit()) {
                ch
            } else {
                val sub = this.substring(index)
                when {
                    sub.startsWith("one") -> '1'
                    sub.startsWith("two") -> '2'
                    sub.startsWith("three") -> '3'
                    sub.startsWith("four") -> '4'
                    sub.startsWith("five") -> '5'
                    sub.startsWith("six") -> '6'
                    sub.startsWith("seven") -> '7'
                    sub.startsWith("eight") -> '8'
                    sub.startsWith("nine") -> '9'
                    else -> ' '
                }
            }
        }

        return "${mapped.first {it.isDigit()}}${mapped.last {it.isDigit()}}".toInt()
    }
}

fun main() {
    val solver = PartTwo()
    println(solver.solve()) // 53268
}