package day04

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day04PartTwoTest {

    val sut = Day04PartTwo(testInput)

    @Test
    fun shouldSolve() {
        val actual = sut.solve()

        assertThat(actual).isEqualTo(30)
    }
}