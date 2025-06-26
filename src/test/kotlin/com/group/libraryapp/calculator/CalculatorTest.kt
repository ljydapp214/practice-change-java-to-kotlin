package com.group.libraryapp.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    private lateinit var calculator: Calculator

    companion object {
        private const val INIT_VALUE = 5
        private const val OPERAND_VALUE = 3
    }

    @BeforeEach
    fun setUp() {
        calculator = Calculator(INIT_VALUE)
    }

    @Test
    fun addTest() {
        calculator.add(OPERAND_VALUE)

        assertThat(calculator).isEqualTo(Calculator(INIT_VALUE + OPERAND_VALUE))
    }

    @Test
    fun minusTest() {
        calculator.minus(OPERAND_VALUE)

        assertThat(calculator).isEqualTo(Calculator(INIT_VALUE - OPERAND_VALUE))
    }

    @Test
    fun multiplyTest() {
        calculator.multiply(OPERAND_VALUE)

        assertThat(calculator).isEqualTo(Calculator(INIT_VALUE * OPERAND_VALUE))
    }

    @Nested
    @DisplayName("계신기에서 나눗셈을 할 때")
    inner class WhenDivide {
        @ParameterizedTest
        @ValueSource(ints = [1, 2, 3])
        fun do_divide(input: Int) {
            calculator.divide(input)

            assertThat(calculator).isEqualTo(Calculator(INIT_VALUE / input))
        }

        @DisplayName("나누고자 하는 분모가 0 일 때, 예외를 던진다.")
        @ParameterizedTest
        @ValueSource(ints = [0])
        fun do_not_divide(zero: Int) {
            assertThatThrownBy { calculator.divide(zero) }
                .isInstanceOf(IllegalArgumentException::class.java)

            assertThrows<IllegalArgumentException> { calculator.divide(zero) }
                .apply { assertThat(message).isEqualTo("0으로는 수를 나눌 수 없습니다.") }
        }
    }
}
