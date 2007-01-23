/*
 * Created on May 10, 2004
 */
package com.hannonhill.commons.util;

/**
 * Helper class to simplify some of the bitwise operations.
 * 
 * @author Collin VanDyck 
 * @since  1.0
 */
public class BitWise
{

    /**
     * Generates a new bitmask using a power of two.
     * 
     * @param power
     * @return
     */
    public static final int newBitMask(int power)
    {
        return (int) Math.pow(2, power);
    }

    /**
     * Sets a bit on the source int, and returns the new int with the bit set
     * 
     * @param source
     * @param bit
     * @return
     */
    public static final int setBit(int source, int bit)
    {
        return source |= bit;
    }

    /**
     * Unsets a bit on the source int, and returns the new int with the bit unset 
     * 
     * @param source
     * @param bit
     * @return
     */
    public static final int unsetBit(int source, int bit)
    {
        return source &= ~bit;
    }

    /**
     * Returns true if the source int does not have a particular bit set
     * 
     * @param source
     * @param bit
     * @return
     */
    public static final boolean bitNotSet(int source, int bit)
    {
        return !bitSet(source, bit);
    }

    /**
     * Returns true if the source int has a particular bit set
     * 
     * @param source
     * @param bit
     * @return
     */
    public static final boolean bitSet(int source, int bit)
    {
        if ((source & bit) == bit)
        {
            return true;
        }
        return false;
    }

    /**
     * Translate a bitwise integer to an array of strings containing
     * each power of two that was set.
     * 
     * For example: source = 27
     * This function will return: {"1","2","8","16"}
     * 
     * NOTE: This function cannot handle negative integers.
     * 
     * @param source an integer composed by using bitwise operations. 
     * @return an array of strings, each representing a power of two.
     */
    public static final String[] translate(int source)
    {
        if (source == 0)
        {
            return new String[0];
        }

        StringBuffer buf = new StringBuffer(16);
        for (int i = 1; i <= source; i *= 2)
        {
            if ((source & i) == i)
            {
                buf.append(Integer.toString(i));
                buf.append(",");
            }
        }

        //get rid of last comma
        if (buf.length() > 0)
        {
            buf.deleteCharAt(buf.length() - 1);
        }

        return buf.toString().split(",");
    }

    /**
     * Translate an array of strings each containing a power of two
     * to an integer composed bitwise
     * 
     * For example: source = {"1","2","8","16"}
     * This function will return 27
     * 
     * @param source
     * @return
     */
    public static final int translate(String[] source)
    {
        if (source == null)
        {
            return 0;
        }

        int accum = 0;
        for (String s : source)
        {
            accum += Integer.parseInt(s);
        }

        return accum;
    }
}
