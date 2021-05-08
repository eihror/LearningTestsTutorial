package com.eihror.learningtests

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.eihror.learningtests.util.lazyActivityScenarioRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

  @get:Rule
  val rule = lazyActivityScenarioRule<MainActivity>(launchActivity = false)

  private lateinit var intent: Intent

  @Before
  fun setUp() {
    intent = Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
  }

  @Test
  fun calculateTest() {
    rule.launch(intent)
    onView(withId(R.id.input_number_one)).perform(clearText(), typeText("10"))
    onView(withId(R.id.operation_add)).perform(click())
    onView(withId(R.id.input_number_two)).perform(clearText(), typeText("2"))
    onView(withId(R.id.button_calculate)).perform(click())

    onView(withId(R.id.text_value)).check(matches(isDisplayed()))
    onView(withId(R.id.button_calculate)).check(matches(isEnabled()))
  }
}