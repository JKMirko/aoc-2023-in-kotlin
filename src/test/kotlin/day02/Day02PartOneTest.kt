package day02

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day02PartOneTest {

    val sut = Day02PartOne(testInput)

    @Test
    fun shouldSolve() {
        val actual = sut.solve()

        assertThat(actual).isEqualTo(8)
    }
}