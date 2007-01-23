/*
 * Created on March 29, 2006 by Collin VanDyck
 */
package com.hannonhill.commons.util;

/**
 * Helper utility methods for dealing with booleans
 * 
 * @author  Collin VanDyck
 * @version $Id: BooleanUtil.java 5279 2006-12-19 21:34:31Z bradley.wagner $
 * @since   4.0
 */
public class BooleanUtil
{

    /**
     * If the specified string is 'yes', 'true', case-insensitive, then
     * true is returned. Else, false is returned.
     * 
     * @param string
     * @return
     */
    public static final boolean valueOf(String string)
    {
        if (StringUtil.isEmpty(string))
        {
            return false;
        }
        string = StringUtil.trim(string);
        if ("yes".equalsIgnoreCase(string))
        {
            return true;
        }
        if ("true".equalsIgnoreCase(string))
        {
            return true;
        }
        return false;
    }

}
