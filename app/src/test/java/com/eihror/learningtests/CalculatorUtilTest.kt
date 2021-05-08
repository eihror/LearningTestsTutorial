package com.eihror.learningtests

import com.eihror.learningtests.Operator.ADD
import com.eihror.learningtests.Operator.DIVIDE
import com.eihror.learningtests.Operator.MULTIPLY
import com.eihror.learningtests.Operator.SUBTRACT
import junit.framework.TestCase
import org.junit.Test

class CalculatorUtilTest : TestCase() {

  private var calculatorUtil: CalculatorUtil? = null

  override fun setUp() {
    super.setUp()
    calculatorUtil = CalculatorUtil()
  }

  override fun tearDown() {
    calculatorUtil = null
  }

  fun test_ValidateOperations() {
    // Operation ADD
    calculatorUtil?.valueOne = 10
    calculatorUtil?.valueTwo = 5
    calculatorUtil?.operation = ADD

    assertEquals("The calculation isn't correct", 15, calculatorUtil?.calculate())

    //Operation SUBTRACT
    calculatorUtil?.valueOne = 10
    calculatorUtil?.valueTwo = 5
    calculatorUtil?.operation = SUBTRACT

    assertEquals("The calculation isn't correct", 5, calculatorUtil?.calculate())

    //Operation DIVIDE
    calculatorUtil?.valueOne = 10
    calculatorUtil?.valueTwo = 5
    calculatorUtil?.operation = DIVIDE

    assertEquals("The calculation isn't correct", 2, calculatorUtil?.calculate())

    //Operation MULTIPLY
    calculatorUtil?.valueOne = 10
    calculatorUtil?.valueTwo = 5
    calculatorUtil?.operation = MULTIPLY

    assertEquals("The calculation isn't correct", 50, calculatorUtil?.calculate())
  }

  @Test
  fun test_CalculateWithoutOperation() {
    calculatorUtil?.valueOne = 10
    calculatorUtil?.valueTwo = 5

    assertEquals("The calculation has operation", -1, calculatorUtil?.calculate())
  }

  @Test
  fun test_CanCalculate() {
    //Operation MULTIPLY
    calculatorUtil?.valueOne = 10
    calculatorUtil?.valueTwo = 5
    calculatorUtil?.operation = MULTIPLY

    assertEquals("Can't calculate", true, calculatorUtil?.isValid())
  }
}