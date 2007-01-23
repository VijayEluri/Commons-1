/*
 * Created on Mar 16, 2004
 *
 * Author: Collin VanDyck
 */
package com.hannonhill.commons.util.string;

import java.util.HashMap;

/**
 * @author Collin VanDyck
 *
 *
 * Utility class to reduce the amount of unecessary calling casts for simple
 * String -> String lookups.
 * 
 */
public class StringMap
{

    private HashMap<String,String> delegate;

    public StringMap()
    {
        super();
        delegate = new HashMap<String,String>();
    }

    /**
     * @param name
     * @param value
     */
    public void put(String name, String value)
    {
        this.delegate.put(name, value);
    }

    /**
     * @param name
     * @return
     */
    public String get(String name)
    {
        return this.delegate.get(name);
    }
}
