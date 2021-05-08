package com.eihror.learningtests

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import junit.framework.TestCase

class MainActivityTest : TestCase() {

  override fun setUp() {
    super.setUp()
    launchActivity<MainActivity>()
  }

  fun test_CalculateTest() {
    onView(withId(R.id.input_number_one)).perform(clearText(), typeText("10"))
    onView(withId(R.id.operation_add)).perform(click())
    onView(withId(R.id.input_number_two)).perform(clearText(), typeText("2"))
    onView(withId(R.id.button_calculate)).perform(click())

    onView(withId(R.id.text_value)).check(matches(isDisplayed()))
    onView(withId(R.id.button_calculate)).check(matches(isEnabled()))
  }
}