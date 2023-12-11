package day02

import java.io.File

class Day02PartOne(
    private val input: String = File("src/main/kotlin/day02/input.txt").readText()
) {

    fun solve(): Int {
        val input = parse(input)

        val possibleGames = input.games.filterNot {
            it.isImpossible()
        }
        return possibleGames.sumOf { it.id }
    }

    val mapOfBalls = mapOf(
        "red" to 12,
        "green" to 13,
        "blue" to 14,
    )
    fun Game.isImpossible(): Boolean {
        return hands.any { hand -> hand.any { it.value > mapOfBalls[it.key]!! } }
    }

}

fun main() {
    val solver = Day02PartOne()
    println(solver.solve()) // 2512
}