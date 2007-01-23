/**
 * 
 */
package com.hannonhill.commons.util;


/**
 * Helper method to use Object.equals() while respecting possible null values.
 * 
 * @author Collin VanDyck
 * @since 4.0
 *
 */
public class EqualsUtil
{

    /**
     * Returns true if the objects are not equal
     * 
     * @param one
     * @param two
     * @return
     */
    public static boolean notEqual(Object one, Object two)
    {
        return !equal(one, two);
    }

    /**
     * Returns true if both objects are equal and non-null.
     * 
     * @param one
     * @param two
     * @return
     */
    public static boolean equal(Object one, Object two)
    {
        if (one == null || two == null)
        {
            return false;
        }
        return one.equals(two);
    }

    /**
     * Returns true if both objects are both null or if they are both non-null and equal.
     * 
     * @param one
     * @param two
     * @return
     */
    public static boolean equalsNullsOK(Object one, Object two)
    {
        if (one == null && two == null)
        {
            return true;
        }
        return equal(one, two);
    }

}
