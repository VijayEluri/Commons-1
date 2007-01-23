package com.hannonhill.commons.util;

/**
 * Utility class to help with character related routines  
 *
 * @author Collin VanDyck
 * @since 4.5
 */
public class CharacterUtil
{

    /**
     * Copies a character array into a new array
     * 
     * @param ch
     * @param start
     * @param length
     * @return
     */
    public static final char[] copy(char[] ch, int start, int length)
    {
        char[] copied = new char[length];
        System.arraycopy(ch, start, copied, 0, length);
        return copied;
    }

}
