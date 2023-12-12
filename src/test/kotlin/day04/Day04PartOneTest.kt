package day04

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day04PartOneTest {

    val sut = Day04PartOne(testInput)

    @Test
    fun shouldSolve() {
        val actual = sut.solve()

        assertThat(actual).isEqualTo(13)
    }
}