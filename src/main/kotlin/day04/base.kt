package day04

import java.io.File

val inputText: String = File("src/main/kotlin/day04/input.txt").readText()

data class Input(
    val cards: List<Card>
)

data class Card(
    val id: Int,
    val winningNumbers: Set<Int>,
    val myNumbers: Set<Int>
)

fun parse(lines: List<String>): Input {
    return Input(
        lines.map { line ->
            val (card, winning, my) = line.split(":", "|")
            val cardNumber = card.filter { it.isDigit() }.toInt()
            val winningNumbers = winning.trim().split("\\s+".toRegex()).map { it.toInt() }
            val myNumbers = my.trim().split("\\s+".toRegex()).map { it.toInt() }

            Card(cardNumber, winningNumbers.toSet(), myNumbers.toSet())
        }
    )
}