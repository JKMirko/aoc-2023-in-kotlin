package day02

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day02PartTwoTest {

    val sut = Day02PartTwo(testInput)

    @Test
    fun shouldSolve() {
        val actual = sut.solve()

        assertThat(actual).isEqualTo(2286)
    }
}