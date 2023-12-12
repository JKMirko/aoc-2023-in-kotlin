package day03

import java.io.File

class Day03PartOne(
    private val input: String = File("src/main/kotlin/day03/input.txt").readText()
) {

    fun solve(): Long {
        val parsedInput = parse(input)

        val filtered = parsedInput.numbers.filter {
            it.adjacentToAnySymbol(parsedInput)
        }
        return filtered.sumOf { it.value }
    }

    fun Number.adjacentToAnySymbol(input: Input): Boolean {
        return input.symbols.any { symbol ->
            symbol.neighbors(input.numOfRows, input.numOfCols).any {
                (it.row == row) && (it.col in colRange)
            }
        }
    }
}

fun main() {
    val solver = Day03PartOne()
    println(solver.solve()) // 546563
}