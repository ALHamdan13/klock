package com.soywiz.klock

import com.soywiz.klock.internal.substr
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
private var KlockLocale_default: KlockLocale = KlockLocale.English

abstract class KlockLocale {
	abstract val ISO639_1: String
	abstract val daysOfWeek: List<String>
	abstract val months: List<String>
	abstract val firstDayOfWeek: DayOfWeek
	open val monthsShort by lazy { months.map { it.substr(0, 3) } }

	open val daysOfWeekShort: List<String> by lazy { daysOfWeek.map { it.substr(0, 3) } }
	@Deprecated("Use months3", ReplaceWith("monthsShort"))
	val months3 get() = monthsShort
	open val h12Marker = listOf("AM", "OM")

	// This might be required for some languages like chinese?
	open fun intToString(value: Int) = "$value"

	open fun isWeekend(dayOfWeek: DayOfWeek): Boolean = dayOfWeek == DayOfWeek.Saturday || dayOfWeek == DayOfWeek.Sunday

	protected fun format(str: String) = PatternDateFormat(str, this)

	open val formatDateTimeMedium = format("MMM d, y h:mm:ss a")
	open val formatDateTimeShort = format("M/d/yy h:mm a")

	open val formatDateFull = format("EEEE, MMMM d, y")
	open val formatDateLong = format("MMMM d, y")
	open val formatDateMedium = format("MMM d, y")
	open val formatDateShort = format("M/d/yy")

	open val formatTimeMedium = format("HH:mm:ss")
	open val formatTimeShort = format("HH:mm")

	companion object {
		val english get() = English

		var default: KlockLocale
			set(value) = run { KlockLocale_default = value }
			get() = KlockLocale_default

		inline fun <R> setTemporarily(locale: KlockLocale, callback: () -> R): R {
			val old = default
			default = locale
			try {
				return callback()
			} finally {
				default = old
			}
		}
	}

	open class English : KlockLocale() {
		companion object : English()

		override val ISO639_1 = "en"

		override val firstDayOfWeek: DayOfWeek = DayOfWeek.Sunday

		override val daysOfWeek: List<String> = listOf(
			"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"
		)
		override val months: List<String> = listOf(
			"january", "february", "march", "april", "may", "june",
			"july", "august", "september", "october", "november", "december"
		)

		override val formatTimeMedium = format("h:mm:ss a")
		override val formatTimeShort = format("h:mm a")
	}
}
