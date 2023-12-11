package day02

fun parse(input: String): Input {
    return Input(input.lines().map { line ->
        val (game, picksString) = line.split(":")
        val gameId = game.trim().filter { it.isDigit() }.toInt()

        val picks = picksString.trim().split(";").map {pick ->
            val balls = pick.trim().split(",").map {
                val (value, key) = it.trim().split(" ")
                Ball(key.trim(), value.trim().toInt())
            }
            balls
        }

        Game(gameId, picks)
    })
}

data class Input(
    val games: List<Game>
)

data class Game(
    val id: Int,
    val hands: List<List<Ball>>
)

data class Ball(
    val key: String,
    val value: Int
)