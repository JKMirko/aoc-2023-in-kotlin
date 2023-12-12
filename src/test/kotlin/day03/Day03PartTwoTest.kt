package day03

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day03PartTwoTest {

    val sut = Day03PartTwo(testInput)

    @Test
    fun shouldSolve() {
        val actual = sut.solve()

        assertThat(actual).isEqualTo(467835L)
    }
}