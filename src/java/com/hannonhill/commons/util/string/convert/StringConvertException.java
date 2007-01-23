/*
 * Created on Apr 6, 2005
 *
 */
package com.hannonhill.commons.util.string.convert;

/**
 * For errors that happen during String conversion. 
 * 
 * @author Collin VanDyck
 */
public class StringConvertException extends Exception
{

    private static final long serialVersionUID = 1L;

    /**
     * @param message
     */
    public StringConvertException(String message)
    {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public StringConvertException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
