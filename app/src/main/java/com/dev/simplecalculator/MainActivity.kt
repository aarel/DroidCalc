package com.dev.simplecalculator

import android.annotation.SuppressLint
import com.dev.simplecalculator.CalculatorLogic
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

        display = findViewById(R.id.display)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btn0 = findViewById<Button>(R.id.btn0)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val btnEquals = findViewById<Button>(R.id.btnEquals)

        calculatorLogic = CalculatorLogic()

        btn1.setOnClickListener {
            // Get the current text from the display
            val currentText = display.text.toString()

            // Append "1" to the current text
            val updatedText = currentText + "1"

            // Update the display with the new text
            display.text = updatedText
        }

        btn2.setOnClickListener {
            val currentText = display.text.toString()
            val updatedText = display.text.toString()
            display.text = updatedText
        }

        btn3.setOnClickListener {
            val currentText = display.text.toString()
            val updatedText = display.text.toString()
            display.text = updatedText
        }

        btn4.setOnClickListener {
            val currentText = display.text.toString()
            val updatedText = display.text.toString()
            display.text = updatedText
        }

        btn5.setOnClickListener {
            val currentText = display.text.toString()
            val updatedText = display.text.toString()
            display.text = updatedText
        }

        btn6.setOnClickListener {
            val currentText = display.text.toString()
            val updatedText = display.text.toString()
            display.text = updatedText
        }

        btn7.setOnClickListener {
            val currentText = display.text.toString()
            val updatedText = display.text.toString()
            display.text = updatedText
        }

        btn8.setOnClickListener {
            val currentText = display.text.toString()
            val updatedText = display.text.toString()
            display.text = updatedText
        }

        btn9.setOnClickListener {
            val currentText = display.text.toString()
            val updatedText = display.text.toString()
            display.text = updatedText
        }

        btn0.setOnClickListener {
            val currentText = display.text.toString()
            val updatedText = display.text.toString()
            display.text = updatedText
        }

        btnAdd.setOnClickListener {
            val currentText = display.text.toString()

            // Check if the last character is an operator
            if (currentText.isNotEmpty() && CalculatorLogic.isOperator(currentText.last())) {
                // If the last character is an operator, replace it with the new operator
                val updatedText = currentText.substring(0, currentText.length - 1) + "+"
                display.text = updatedText
            } else {
                // Append the "+" operator to the current text
                display.text = "$currentText+"
            }
        }

        btnSubtract.setOnClickListener {
            val currentText = display.text.toString()

            // Check if the last character is an operator
            if (currentText.isNotEmpty() && CalculatorLogic.isOperator(currentText.last())) {
                // If the last character is an operator, replace it with the new operator
                val updatedText = currentText.substring(0, currentText.length - 1) + "-"
                display.text = updatedText
            } else {
                // Append the "-" operator to the current text
                display.text = "$currentText-"
            }
        }

        btnMultiply.setOnClickListener {
            val currentText = display.text.toString()

            // Check if the last character is an operator
            if (currentText.isNotEmpty() && CalculatorLogic.isOperator(currentText.last())) {
                // If the last character is an operator, replace it with the new operator
                val updatedText = currentText.substring(0, currentText.length - 1) + "*"
                display.text = updatedText
            } else {
                // Append the "*" operator to the current text
                display.text = "$currentText*"
            }
        }

        btnDivide.setOnClickListener {
            val currentText = display.text.toString()

            // Check if the last character is an operator
            if (currentText.isNotEmpty() && CalculatorLogic.isOperator(currentText.last())) {
                // If the last character is an operator, replace it with the new operator
                val updatedText = currentText.substring(0, currentText.length - 1) + "/"
                display.text = updatedText
            } else {
                // Append the "/" operator to the current text
                display.text = "$currentText/"
            }
        }

        btnEquals.setOnClickListener {
            val currentValue = display.text.toString()
            val lastChar = currentValue.lastOrNull()

            if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/') {
                // If the last character is an operator, append the current value
                display.text = "${currentValue}0"
            } else {
                // Perform the calculation and update the display
                val result = CalculatorLogic.calculate(currentValue)
                display.text = result.toString()
            }
        }
    }
    private fun updateDisplay(text: String) {
        display.text = text
    }
}