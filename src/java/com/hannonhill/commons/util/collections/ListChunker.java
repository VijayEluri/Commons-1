/*
 * Created on Aug 9, 2005
 */
package com.hannonhill.commons.util.collections;

import java.util.List;

/**
 * Utility list class used to grab groups of objects from a list some number at a time
 * until the list no longer contains any items.
 * 
 * Can specify a max group size in the constructor. 
 * 
 * @author  Bradley M. Wagner
 * @version $Id: ListChunker.java 5197 2006-11-28 01:47:00Z bradley.wagner $
 * @since   3.5.3
 */
public class ListChunker<T>
{

    private List<T> list;
    private int maxGroupSize;

    /**
     * Constructor
     * @param list Input list to chunkify
     * @parma maxGroupSize specifies the max number of objects to return in a group
     */
    public ListChunker(List<T> list, int maxGroupSize)
    {
        this.list = list;
        this.maxGroupSize = maxGroupSize;
    }

    /**
     * Gets a sublist of the original list with min(list.size(),maxGroupSize) objects,
     * or null if the list is empty or null. Truncates the original list on each successive call.
     * 
     * @return Returns a sublist of the original list or null if the original list is empty or null
     */
    public List<T> getNextGroup()
    {
        if (list.size() == 0 || list == null)
        {
            return null;
        }

        int maxIndex = Math.min(maxGroupSize, list.size());
        List<T> result = list.subList(0, maxIndex);

        list = list.subList(maxIndex, list.size());

        return result;
    }
}