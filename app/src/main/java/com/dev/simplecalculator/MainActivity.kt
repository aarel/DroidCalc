package com.dev.simplecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private lateinit var calculatorLogic: CalculatorLogic

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize display and calculator logic
        display = findViewById(R.id.display)
        calculatorLogic = CalculatorLogic()

        // Retrieve the string arrays from resources
        val numbers = resources.getStringArray(R.array.number_buttons)
        val operators = resources.getStringArray(R.array.operator_buttons)

        // Set up number and operator buttons with their IDs
        val numberButtonIds = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        val operatorButtonIds = mapOf(
            R.id.btnAdd to "+",
            R.id.btnSubtract to "-",
            R.id.btnMultiply to "*",
            R.id.btnDivide to "/"
        )

        // Dynamically set text and onClick listeners for number buttons
        numberButtonIds.forEachIndexed { index, buttonId ->
            val button = findViewById<Button>(buttonId)
            button.text = numbers[index]
            button.setOnClickListener {
                display.text = "${display.text}${button.text}"
            }
        }

        // Dynamically set text and onClick listeners for operator buttons
        operatorButtonIds.forEach { (buttonId, operator) ->
            val button = findViewById<Button>(buttonId)
            button.text = operator
            button.setOnClickListener {
                val currentText = display.text.toString()

                // Check if the last character is an operator
                if (currentText.isNotEmpty() && CalculatorLogic.isOperator(currentText.last())) {
                    // Replace the last operator
                    display.text = currentText.dropLast(1) + operator
                } else {
                    // Append the operator
                    display.text = "$currentText$operator"
                }
            }
        }

        // Set up Equals button
        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            val currentValue = display.text.toString()
            val lastChar = currentValue.lastOrNull()

            if (lastChar in listOf('+', '-', '*', '/')) {
                display.text = "${currentValue}0"
            } else {
                val result = CalculatorLogic.calculate(currentValue)
                display.text = result.toString()
            }
        }

        // Set up Clear button
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            display.text = ""
        }
    }

    private fun updateDisplay(text: String) {
        display.text = text
    }
}
