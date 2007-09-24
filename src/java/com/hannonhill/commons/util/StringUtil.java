/*
 * Created on Nov 30, 2004
 *
 */
package com.hannonhill.commons.util;

import java.io.UnsupportedEncodingException;

/**
 * Convenience class for Strings
 * 
 * @author Collin VanDyck
 * @since 3.x
 */
public final class StringUtil
{

    public static final int DEFAULT_LENGTH = 80;

    /** assumed average length of each string being concatenated */
    private static final int ASSUMED_AVERAGE_STRING_LENGTH = 50;

    /**
     * Compares two strings ingoring case, avoiding possible NPEs
     * 
     * @param one
     * @param two
     * @return
     */
    public static final int compareToIgnoreCase(String one, String two)
    {
        if (one == null)
        {
            return 1;
        }
        if (two == null)
        {
            return -1;
        }
        return one.compareToIgnoreCase(two);
    }

    /**
     * Concatenates a variable number of Objects using a StringBuilder. Each object will
     * be converted to a string if it is not already a String.m
     * 
     * @param objects
     * @return
     */
    public static final String concat(Object... objects)
    {
        if (objects == null)
            return null;

        int length = objects.length;

        if (length == 0)
            return null;

        StringBuilder builder = new StringBuilder(length * ASSUMED_AVERAGE_STRING_LENGTH);

        for (int idx = 0, n = objects.length; idx < n; idx++)
        {
            Object object = objects[idx];
            if (object == null)
                continue;

            if (object instanceof String)
                builder.append((String) object);
            else
                builder.append(object.toString());

        }

        return builder.toString();
    }

    /**
     * Performs a trim on the string if the string is not null.  This is
     * a convenience method to avoid additional null checks when trimming
     * a string.  If the input string is null, null will be returned.
     * 
     * @param string
     * @return
     */
    public static final String trim(String string)
    {
        if (string == null)
        {
            return null;
        }
        return string.trim();
    }

    /**
     * Determines if a string is either null or empty ("")
     * 
     * @param string
     * @return
     */
    public static final boolean isEmpty(String string)
    {
        if (string == null)
        {
            return true;
        }
        if (string.length() == 0)
        {
            return true;
        }
        return false;
    }

    /**
     * Determines if a string is not null and not the empty string
     * 
     * @param string
     * @return
     */
    public static final boolean isNotEmpty(String string)
    {
        if (string == null)
        {
            return false;
        }
        if (string.length() == 0)
        {
            return false;
        }
        return true;
    }

    /**
     * Returns true if the trimmed version of the string is
     * not empty.
     * 
     * @param string
     * @return
     */
    public static final boolean isNotEmptyTrimmed(String string)
    {
        if (string == null)
        {
            return false;
        }
        if (string.length() == 0)
        {
            return false;
        }
        return isNotEmpty(string.trim());
    }

    /**
     * Determines if a trimmed string is either null or empty ("")
     * 
     * @param string
     * @return
     */
    public static final boolean isEmptyTrimmed(String string)
    {
        if (string == null)
        {
            return true;
        }
        if (string.length() == 0)
        {
            return true;
        }
        return isEmpty(string.trim());
    }

    /**
     * Produces a substring that is no more than maxLength characters long.
     * 
     * @param string
     * @param maxLength
     * @return
     */
    public static final String subString(String string, int maxLength)
    {
        if (string == null)
        {
            return string;
        }
        final int stringLength = string.length();
        if (stringLength <= maxLength)
        {
            return string;
        }
        return string.substring(0, maxLength);
    }

    /**
     * Produces a substring that is no more than DEFAULT_LENGTH characters long
     * 
     * @param string
     * @return
     */
    public static final String subString(String string)
    {
        return subString(string, DEFAULT_LENGTH);
    }

    /**
     * Produces a string which does not contain any invalid characters:
     * Chars with an ascii value of 0-8, 11, 12, 14-31, 127-159
     * 
     * @param string
     * @return
     */
    public static final String removeInvalidCharacters(String string)
    {
        StringBuffer sb = new StringBuffer(string.length());
        for (int idx = 0, max = string.length(); idx < max; idx++)
        {
            int iChar = (int) string.charAt(idx);
            if ((iChar > 8 && iChar < 11) || (iChar > 12 && iChar < 14) || (iChar > 31 && iChar < 127) || (iChar > 159))
            {
                sb.append((char) iChar);
            }
        }
        return sb.toString().trim();
    }

    /**
     * Returns the proper case for a string (having the first character upper case and the rest lower case)
     * 
     * @param string
     * @return
     */
    public static final String toProperCase(String string)
    {
        if (string != null && string.length() > 1)
        {
            StringBuffer sbToReturn = new StringBuffer(100);
            sbToReturn.append((String.valueOf(string.charAt(0))).toUpperCase());
            sbToReturn.append(string.substring(1, string.length()).toLowerCase());
            return sbToReturn.toString();
        }
        return string;

    }

    public static final String removeLeadingCharacters(String inputString, char targetChar)
    {
        if (isEmpty(inputString))
        {
            return (inputString);
        }

        StringBuffer sbuf = new StringBuffer(inputString);
        //start at first char
        int i = 0;
        //walk from beginning of string until we find the first non-targetChar
        while (i < inputString.length() && sbuf.charAt(i) == targetChar)
        {
            i++;
        }
        sbuf.delete(0, i);
        return (sbuf.toString());
    }

    /**
     * Returns the string produced after removing all instances of targetChar from the
     * end of inputString. Example: "xyzaaa,a" produces "xyz"    
     * 
     * @param inputString the input string from which to remove characters
     * @param targetChar the character to remove
     * @return the modified string
     */
    public static final String removeTrailingCharacters(String inputString, char targetChar)
    {
        if (isEmpty(inputString))
        {
            return (inputString);
        }
        StringBuffer sbuf = new StringBuffer(inputString);

        //start at the last char
        int i = inputString.length() - 1;
        //walk from the end of the string to the first non-targetChar
        while (i >= 0 && sbuf.charAt(i) == targetChar)
        {
            i--;
        }
        sbuf.delete(i + 1, inputString.length());
        return (sbuf.toString());
    }

    /**
     * Returns the asset name from the full asset path
     * @param cachePath the full path of the entity
     * @return the entity name
     */
    public static final String returnNameFromCachePath(String cachePath)
    {
        String toReturn = cachePath;
        if (StringUtil.isNotEmpty(cachePath))
        {
            int i = cachePath.lastIndexOf('/');
            if (i > -1)
                toReturn = cachePath.substring(i + 1);
        }
        return toReturn;
    }

    /**
     * Companion method to toString(byte[]), converts in the other direction. No encoding
     * is ncessary.
     * 
     * @param string the string to convert to byte
     * @return a byte array
     */
    public static final byte[] toBytes(String string)
    {
        if (string == null)
        {
            return null;
        }
        return string.getBytes();
    }

    /**
     * Converts a byte array to a String, assuming UTF-8 encoding.
     * 
     * @param bytes the array of bytes
     * @return the string object
     */
    public static final String toString(byte[] bytes)
    {
        if (bytes == null)
        {
            return null;
        }

        String result;
        try
        {
            result = new String(bytes, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            return new String(bytes);
        }
        return result;
    }

    /**
     * Removes all the whitespace from a string
     * 
     * @param s the String whose whitespace will be removed
     * @return the String with no whitespace characters (see "\s")
     */
    public static final String removeWhitespace(String s)
    {
        return s.replaceAll("\\s", "");
    }
}
