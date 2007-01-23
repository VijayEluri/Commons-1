/*
 * Sep 27, 2006 
 */
package com.hannonhill.commons.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.lang.Validate;

/**
 * Utility class to handle common exception handling routines
 * 
 * @author Collin VanDyck
 * @since 4.6
 */
public class ExceptionUtil
{
    /**
     * Returns the exception as a String message. If the Exception's getMessage()
     * function returns nothing, then the exception will be printed out as a stack
     * trace and returned in String format.
     * 
     * @param e
     * @return
     */
    public static String asMessage(Throwable e)
    {
        Validate.notNull(e, "Throwable may not be null");

        String message = e.getMessage();
        if (StringUtil.isNotEmptyTrimmed(message))
        {
            return message;
        }

        StringWriter writer = new StringWriter();
        e.printStackTrace(new PrintWriter(writer));
        return writer.toString();
    }
}
