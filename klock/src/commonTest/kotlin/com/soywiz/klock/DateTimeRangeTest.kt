package com.soywiz.klock

import kotlin.test.Test
import kotlin.test.assertEquals

class DateTimeRangeTest {
    val format = ISO8601.DATETIME_COMPLETE
    fun String.date() = format.parseUtc(this)
    fun range(from: Int, to: Int) = (DateTime.EPOCH + from.milliseconds)..(DateTime.EPOCH + to.milliseconds)

    @Test
    fun test() {
        val range1 = "2019-09-17T13:53:31".date() until "2019-10-17T07:00:00".date()
        val range2 = "2019-09-17T14:53:31".date() until "2019-10-17T08:00:00".date()
        val range3 = "2019-10-19T00:00:00".date() until "2019-10-20T00:00:00".date()
        assertEquals("2019-09-17T14:53:31..2019-10-17T07:00:00", range1.intersectionWith(range2)?.toString(format))
        assertEquals(null, range1.intersectionWith(range3)?.toString(format))
    }

    @Test
    fun test2() {
        assertEquals("[]", DateTimeRangeSet.toStringLongs(range(0, 100).without(range(0, 100))))
        assertEquals("[50..100]", DateTimeRangeSet.toStringLongs(range(0, 100).without(range(-50, 50))))
        assertEquals("[0..100]", DateTimeRangeSet.toStringLongs(range(0, 100).without(range(-50, -10))))
        assertEquals("[0..100]", DateTimeRangeSet.toStringLongs(range(0, 100).without(range(-50, 0))))
        assertEquals("[0..20, 70..100]", DateTimeRangeSet.toStringLongs(range(0, 100).without(range(20, 70))))
        assertEquals("[0..50]", DateTimeRangeSet.toStringLongs(range(0, 100).without(range(50, 100))))
        assertEquals("[0..50]", DateTimeRangeSet.toStringLongs(range(0, 100).without(range(50, 120))))
        assertEquals("[0..100]", DateTimeRangeSet.toStringLongs(range(0, 100).without(range(100, 120))))
        assertEquals("[0..100]", DateTimeRangeSet.toStringLongs(range(0, 100).without(range(120, 200))))
    }
}
