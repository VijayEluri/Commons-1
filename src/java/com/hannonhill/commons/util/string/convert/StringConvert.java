/*
 * Created on Apr 6, 2005
 */
package com.hannonhill.commons.util.string.convert;

/**
 * Interface for converting a string into another string.
 * 
 * @author Collin VanDyck
 * @since  1.0
 */
public interface StringConvert
{

    /**
     * Converts the input String into an output String
     * 
     * @param input
     * @return
     * @throws StringConvertException
     */
    public String convert(String input) throws StringConvertException;
}