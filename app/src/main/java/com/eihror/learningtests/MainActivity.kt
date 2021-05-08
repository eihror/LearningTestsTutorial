package com.eihror.learningtests

import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.doOnTextChanged
import com.eihror.learningtests.Operator.ADD
import com.eihror.learningtests.Operator.DIVIDE
import com.eihror.learningtests.Operator.MULTIPLY
import com.eihror.learningtests.Operator.SUBTRACT

class MainActivity : AppCompatActivity(R.layout.activity_main) {

  private val calculator: CalculatorUtil = CalculatorUtil()

  private lateinit var numberOne: AppCompatEditText
  private lateinit var numberTwo: AppCompatEditText
  private lateinit var groupButtons: RadioGroup
  private lateinit var buttonCalculate: AppCompatButton
  private lateinit var result: AppCompatTextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    numberOne = findViewById(R.id.input_number_one)
    numberTwo = findViewById(R.id.input_number_two)
    groupButtons = findViewById(R.id.group_buttons)
    buttonCalculate = findViewById(R.id.button_calculate)
    result = findViewById(R.id.text_value)

    setupView()
    setupActions()
  }

  private fun setupView() {
    validateFields()

    numberOne.doOnTextChanged { value, _, _, _ ->
      calculator.valueOne = if (!value.isNullOrEmpty()) value.toString().toInt() else 0
      validateFields()
    }

    numberTwo.doOnTextChanged { value, _, _, _ ->
      calculator.valueTwo = if (!value.isNullOrEmpty()) value.toString().toInt() else 0
      validateFields()
    }

    groupButtons.setOnCheckedChangeListener { _, checkedId ->
      when (checkedId) {
        R.id.operation_add -> calculator.operation = ADD
        R.id.operation_subtract -> calculator.operation = SUBTRACT
        R.id.operation_divide -> calculator.operation = DIVIDE
        R.id.operation_multiply -> calculator.operation = MULTIPLY
      }
      validateFields()
    }
  }

  private fun setupActions() {
    buttonCalculate.setOnClickListener {
      result.text = ""
      result.text = calculator.calculate().toString()
    }
  }

  private fun validateFields() {
    buttonCalculate.apply {
      isEnabled = calculator.isValid()
      alpha = if (calculator.isValid()) 1f else 0.3f
    }
  }
}