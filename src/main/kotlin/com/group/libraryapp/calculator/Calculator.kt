package com.group.libraryapp.calculator

data class Calculator(
    private var number:Int
) {
    fun add(operand: Int) {
        this.number += operand
    }

    fun minus(operand: Int) {
        this.number -= operand
    }

    fun multiply(operand: Int) {
        this.number *= operand
    }

    fun divide(operand: Int) {
        if (operand == 0) {
            throw IllegalArgumentException("Cannot divide by zero")
        }
        this.number /= operand
    }
}

// backing property 이용
data class CalculatorV2(
    private var _number:Int
) {
    val number: Int
        get() = this._number


    fun add(operand: Int) {
        this._number += operand
    }

    fun minus(operand: Int) {
        this._number -= operand
    }

    fun multiply(operand: Int) {
        this._number *= operand
    }

    fun divide(operand: Int) {
        if (operand == 0) {
            throw IllegalArgumentException("Cannot divide by zero")
        }
        this._number /= operand
    }
}