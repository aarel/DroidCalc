package com.dev.simplecalculator

import java.util.Stack

class CalculatorLogic {
    companion object {
        fun isOperator(char: Char): Boolean {
            return char == '+' || char == '-' || char == '*' || char == '/'
        }

        fun calculate(expression: String): Double {
            val stack = Stack<Double>()
            val operators = Stack<Char>()

            for (char in expression) {
                when (char) {
                    '+' -> operators.push('+')
                    '-' -> operators.push('-')
                    '*' -> operators.push('*')
                    '/' -> operators.push('/')
                    '(' -> operators.push('(')
                    ')' -> {
                        while (operators.isNotEmpty() && operators.peek() != '(') {
                            performOperation(stack, operators)
                        }
                        operators.pop() // Remove the '('
                    }
                    else -> {
                        val number = char.toString().toDoubleOrNull()
                        if (number != null) {
                            stack.push(number)
                        }
                    }
                }
            }

            while (operators.isNotEmpty()) {
                performOperation(stack, operators)
            }

            return stack.pop()
        }

        private fun performOperation(stack: Stack<Double>, operators: Stack<Char>) {
            val operand2 = stack.pop()
            val operand1 = stack.pop()
            val operator = operators.pop()

            val result = when (operator) {
                '+' -> operand1 + operand2
                '-' -> operand1 - operand2
                '*' -> operand1 * operand2
                '/' -> operand1 / operand2
                else -> throw IllegalArgumentException("Invalid operator: $operator")

            }

            stack.push(result)
        }

    }
}