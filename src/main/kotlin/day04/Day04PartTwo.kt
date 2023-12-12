package day04

class Day04PartTwo(
    private val input: String = inputText
) {

    fun solve(): Int {
        val parsed = parse(input.lines())

        val extendedCards = parsed.cards.map {
            ExtendedCard(it)
        }

        var count = 0
        extendedCards.forEachIndexed { index, ec ->
            repeat(ec.count) {
                count++
                val winningPoints = ec.card.toPoints()
                ((index + 1) until (index + 1 + winningPoints)).forEach {
                    extendedCards[it].count++
                }
            }
        }

        return count
    }

    fun Card.toPoints(): Int {
        return (winningNumbers intersect myNumbers).size
    }
}

data class ExtendedCard(
    val card: Card,
    var count: Int = 1,
)

fun main() {
    val solver = Day04PartTwo()
    println(solver.solve()) // 10425665
}
