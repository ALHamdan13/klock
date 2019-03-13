package com.soywiz.klock

import kotlin.test.Test
import kotlin.test.assertEquals

class DayOfWeekTest {
	@Test
	fun testFirstDayOfWeek() {
		assertEquals(DayOfWeek.Sunday, DayOfWeek.firstDayOfWeek(KlockLocale.english))
	}

	@Test
	fun testIsWeekend() {
		assertEquals(
			listOf(true, false, false, false, false, false, true),
			DayOfWeek.values().map { it.isWeekend(KlockLocale.english) }
		)
	}
}
