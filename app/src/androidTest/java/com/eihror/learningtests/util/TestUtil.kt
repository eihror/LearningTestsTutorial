package com.eihror.learningtests.util

import android.app.Activity
import androidx.test.ext.junit.rules.ActivityScenarioRule
import java.util.concurrent.atomic.AtomicReference

object TestUtil {
  fun <T : Activity?> getActivity(activityScenarioRule: ActivityScenarioRule<T>): T {
    val activityRef: AtomicReference<T> = AtomicReference()
    activityScenarioRule.scenario.onActivity(activityRef::set)
    return activityRef.get()
  }
}