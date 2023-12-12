package day04

class Day04PartOne(
    private val input: String = inputText
) {

    fun solve(): Int {
        val parsed = parse(input.lines())

        return parsed.cards.sumOf {
            it.toValue()
        }
    }

    fun Card.toValue(): Int {
        val same = winningNumbers intersect myNumbers

        return if (same.isEmpty()) 0 else 1 shl (same.size - 1)
    }

}

fun main() {
    val solver = Day04PartOne()
    println(solver.solve()) // 21558
}