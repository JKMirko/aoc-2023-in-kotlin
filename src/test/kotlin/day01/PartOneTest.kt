package day01

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class PartOneTest {

    val sut = PartOne(testInput)

    @Test
    fun shouldSolve() {
        val actual = sut.solve()

        assertThat(actual).isEqualTo(142)
    }
}