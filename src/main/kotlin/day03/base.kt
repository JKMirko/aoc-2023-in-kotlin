package day03

fun parse(text: String): Input {
    val lines = text.lines()
    val numOfRows = lines.size
    val numOfCols = lines[0].length

    val numbers = lines.mapIndexed { rowIndex, s ->
        var startIndex = 0
        var insideNumber = false
        buildList {
            s.forEachIndexed { colIndex, c ->
                if (insideNumber) {
                    if (!c.isDigit()) {
                        insideNumber = false
                        val numberValue = s.substring(startIndex, colIndex).toLong()
                        add(Number(numberValue, rowIndex, startIndex until colIndex))
                    } else if (colIndex == numOfCols - 1) {
                        val numberValue = s.substring(startIndex, numOfCols).toLong()
                        add(Number(numberValue, rowIndex, startIndex until numOfCols))
                    }
                } else {
                    if (c.isDigit()) {
                        insideNumber = true
                        startIndex = colIndex
                    }
                }
            }
        }
    }.flatten()

    val symbols = lines.mapIndexed { rowIndex, s ->
        buildList {
            s.forEachIndexed { colIndex, c ->
                if (!(c.isDigit() || c == '.')) {
                    add(Symbol(c, rowIndex, colIndex))
                }
            }
        }
    }.flatten()

    return Input(numOfRows, numOfCols, numbers, symbols)
}

data class Input(
    val numOfRows: Int,
    val numOfCols: Int,
    val numbers: List<Number>,
    val symbols: List<Symbol>
)

data class Number(
    val value: Long,
    val row: Int,
    val colRange: IntRange
)

data class Symbol(
    val value: Char,
    val row: Int,
    val col: Int
) {

    val neighborVectors = listOf(
        Point(-1, -1),
        Point(-1, 0),
        Point(-1, 1),

        Point(0, -1),
        Point(0, 1),

        Point(1, -1),
        Point(1, 0),
        Point(1, 1),
    )

    fun neighbors(numOfRows: Int, numOfCols: Int): List<Point> {
        return neighborVectors.map { Point(it.row + row, it.col + col) }.filter {
            (it.row in 0 .. numOfRows) && (it.col in 0 .. numOfCols)
        }
    }
}

data class Point(
    val row: Int,
    val col: Int
)