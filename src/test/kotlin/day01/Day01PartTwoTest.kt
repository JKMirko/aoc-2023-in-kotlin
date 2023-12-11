package day01

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day01PartTwoTest {

    val sut = Day01PartTwo(testInput2)

    @Test
    fun shouldSolve() {
        val actual = sut.solve()

        assertThat(actual).isEqualTo(281)
    }
}