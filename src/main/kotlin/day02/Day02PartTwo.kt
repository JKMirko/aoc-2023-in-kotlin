package day02

import java.io.File
import kotlin.math.max

class Day02PartTwo(
    private val input: String = File("src/main/kotlin/day02/input.txt").readText()
) {

    fun solve(): Int {
        val input = parse(input)

        return input.games.sumOf {
            it.power()
        }
    }

    fun Game.power(): Int {
        val minMap =  mutableMapOf(
            "blue" to 0,
            "red" to 0,
            "green" to 0,
        )
        hands.flatten().forEach {
            minMap[it.key] = max(minMap[it.key]!!, it.value)
        }

        return minMap.values.reduce { acc, value -> acc * value }
    }
}

fun main() {
    val solver = Day02PartTwo()
    println(solver.solve()) // 67335
}