package com.hannonhill.commons.util;

import java.util.Collection;

/**
 * Utility class for collections
 * 
 * @author Collin VanDyck
 * @since 4.0
 */
public class CollectionUtil {

	/**
	 * Returns true if the collection is either null or empty
	 * 
	 * @param collection
	 * @return
	 */
	public static final boolean isEmpty(Collection collection)
	{
		if (collection == null || collection.size() == 0)
		{
			return true;
		}
		return false;
	}
	
    
    /**
     * Returns true if the array is either null or empty.
     * 
     * @param array
     * @return
     */
    public static final boolean isEmpty(Object[] array)
    {
        if (array == null || array.length == 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Removes an element from an array and returns the resulting array
     * 
     * @param toRemove the index of the array element to be removed
     * @param array the array to shrink
     * @return
     */
    public static String[] remove(int toRemove, String[] array)
    {	
	String[] b = new String[array.length-1];
	System.arraycopy( array, 0, b, 0, toRemove );
	System.arraycopy( array, toRemove+1, b, toRemove, b.length-toRemove );
	return b;
    }
}
