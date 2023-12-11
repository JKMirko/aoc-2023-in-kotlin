package day01

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day01PartOneTest {

    val sut = Day01PartOne(testInput)

    @Test
    fun shouldSolve() {
        val actual = sut.solve()

        assertThat(actual).isEqualTo(142)
    }
}