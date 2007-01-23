/*
 * Sep 27, 2006 
 */
package com.hannonhill.commons.util;

import com.hannonhill.commons.junit.HHTestCase;

/**
 * Tests the ExceptionUtil utility class
 * 
 * @author Collin VanDyck
 * @since 4.6
 */
public class TestExceptionUtil extends HHTestCase
{
    /**
     * Tests that a NullPointerException is handled correctly.
     */
    public void testNPEHandled()
    {
        NullPointerException exception = new NullPointerException();
        String message = ExceptionUtil.asMessage(exception);

        assertTrue(StringUtil.isNotEmptyTrimmed(message));
    }
}
