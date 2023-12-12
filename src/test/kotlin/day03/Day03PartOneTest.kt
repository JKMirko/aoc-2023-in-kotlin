package day03

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day03PartOneTest {

    val sut = Day03PartOne(testInput)

    @Test
    fun shouldSolve() {
        val actual = sut.solve()

        assertThat(actual).isEqualTo(4361)
    }
}