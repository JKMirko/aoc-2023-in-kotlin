package day03

import java.io.File

class Day03PartTwo(
    private val input: String = File("src/main/kotlin/day03/input.txt").readText()
) {

    fun solve(): Long {
        val parsedInput = parse(input)

        val filtered = parsedInput.symbols.filter { it.value == '*' }
            .map { symbol ->
                parsedInput.numbers.filter { number ->
                    number.isAdjacentToSymbol(symbol, parsedInput)
                }
            }.filter { it.size == 2 }

        return filtered.sumOf {numbers ->
            numbers.map {
                it.value
            }.reduce { acc, l -> acc * l }
        }
    }

    fun Number.isAdjacentToSymbol(symbol: Symbol, input: Input): Boolean {
        return symbol.neighbors(input.numOfRows, input.numOfCols).any {
            (it.row == row) && (it.col in colRange)
        }
    }
}

fun main() {
    val solver = Day03PartTwo()
    println(solver.solve()) // 91031374
}