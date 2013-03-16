package com.hannonhill.commons.util;

import java.util.Locale;

import com.hannonhill.commons.util.DateFormatter.DateFormatEnum;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestDateFormatter extends TestCase {

	public void testFormatLong() {
		String formatted = DateFormatter.format(1366042350000L);
		Assert.assertEquals("Apr 15, 2013 12:12 PM", formatted);
	}

	public void testFormatLongLocale() {
		String formatted = DateFormatter.format(1366042350000L, Locale.FRENCH);
		Assert.assertEquals("15 avr. 2013 12:12", formatted);
	}

	public void testFormatLongDateFormatEnumDateFormatEnum() {
		String formatted = DateFormatter.format(1366042350000L, DateFormatEnum.SHORT, DateFormatEnum.NULL);
		Assert.assertEquals("4/15/13", formatted);
		
		formatted = DateFormatter.format(1366042350000L, DateFormatEnum.NULL, DateFormatEnum.MEDIUM);
		Assert.assertEquals("12:12:30 PM", formatted);
		
		formatted = DateFormatter.format(1366042350000L, DateFormatEnum.FULL, DateFormatEnum.FULL);
		Assert.assertEquals("Monday, April 15, 2013 12:12:30 PM EDT", formatted);
	}

	public void testFormatLongDateFormatEnumDateFormatEnumLocale() {
		String formatted = DateFormatter.format(1366042350000L, DateFormatEnum.SHORT, DateFormatEnum.NULL, Locale.FRENCH);
		Assert.assertEquals("15/04/13", formatted);
		
		formatted = DateFormatter.format(1366042350000L, DateFormatEnum.NULL, DateFormatEnum.MEDIUM, Locale.FRENCH);
		Assert.assertEquals("12:12:30", formatted);
		
		formatted = DateFormatter.format(1366042350000L, DateFormatEnum.FULL, DateFormatEnum.FULL, Locale.FRENCH);
		Assert.assertEquals("lundi 15 avril 2013 12 h 12 EDT", formatted);
	}

	public void testToDhms() {
		int[] dhms = DateFormatter.toDhms(363662003L);
		Assert.assertEquals(dhms[0], 4);
		Assert.assertEquals(dhms[1], 5);
		Assert.assertEquals(dhms[2], 1);
		Assert.assertEquals(dhms[3], 2);
		Assert.assertEquals(dhms[4], 3);
	}

	public void testToDhmsString() {
		String dhms = DateFormatter.toDhmsString(363662003L);
		Assert.assertEquals("4d:5h:1m:2s:3ms", dhms);
	}

	public void testFormatMetaDataDate() {
		String formatted = DateFormatter.formatMetaDataDate(1366042350000L);
		Assert.assertEquals("Mon, 15 Apr 2013 12:12:30 -0560", formatted);
	}

}
