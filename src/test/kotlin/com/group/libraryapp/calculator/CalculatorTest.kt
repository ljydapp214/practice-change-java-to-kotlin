package com.group.libraryapp.calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun addTest() {
        val calculator = Calculator(5)
        calculator.add(3)

        assertThat(calculator).isEqualTo(Calculator(8))

//        val calculatorV2 = CalculatorV2(5)
//        assertThat(calculatorV2.number).isEqualTo(5)
    }
}