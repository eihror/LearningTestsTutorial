package com.eihror.learningtests

import com.eihror.learningtests.Operator.ADD
import com.eihror.learningtests.Operator.DIVIDE
import com.eihror.learningtests.Operator.MULTIPLY
import com.eihror.learningtests.Operator.SUBTRACT

enum class Operator {
  ADD,
  SUBTRACT,
  DIVIDE,
  MULTIPLY
}

class CalculatorUtil {

  var valueOne: Int? = null
  var valueTwo: Int? = null
  var operation: Operator? = null

  fun calculate(): Int {
    return operation?.let {
      when (it) {
        ADD -> valueOne!!.plus(valueTwo!!)
        SUBTRACT -> valueOne!!.minus(valueTwo!!)
        DIVIDE -> valueOne!!.div(valueTwo!!)
        MULTIPLY -> valueOne!!.times(valueTwo!!)
      }
    } ?: run {
      -1
    }
  }

  fun isValid(): Boolean {
    val valueOneIsValid = valueOne != null && valueOne!! >= 1
    val valueTwoIsValid = valueTwo != null && valueTwo!! >= 1
    val operatorIsValid = operation != null
    return valueOneIsValid && valueTwoIsValid && operatorIsValid
  }
}