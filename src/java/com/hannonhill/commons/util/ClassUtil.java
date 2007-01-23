/*
 * Created on July 20, 2006 by Collin VanDyck
 */
package com.hannonhill.commons.util;

import java.io.InputStream;

import org.apache.log4j.Logger;

/**
 * Utility to help with classes and class resource loading issues
 *
 * @author  Collin VanDyck
 * @version $Id: ClassUtil.java 5359 2007-01-12 17:17:26Z bradley.wagner $
 * @since   4.4
 */
public class ClassUtil
{

    private static final Logger LOG = Logger.getLogger(ClassUtil.class);

    /**
     * Loads a relative class resource using Class.getResourceAsInputStream(). The class
     * is determined by the caller object.  The fully qualified path of the resource
     * is determined by the package of the class of the calling object combined with the
     * name of the resource.
     * 
     * @param caller
     * @param name
     * @return
     */
    public static final InputStream relativeInputStream(Class caller, String name)
    {
        if (caller == null)
        {
            throw new IllegalArgumentException("Caller must be supplied");
        }
        if (StringUtil.isEmptyTrimmed(name))
        {
            throw new IllegalArgumentException("Name of resource must be supplied");
        }

        String className = caller.getName();
        String[] segments = className.split("\\.");
        if (segments.length <= 1)
        {

        }

        StringBuilder builder = new StringBuilder();
        builder.append("/");

        for (int idx = 0; idx < segments.length - 1; idx++)
        {
            builder.append(segments[idx]);
            builder.append("/");
        }
        builder.append(name);

        String resourcePath = builder.toString();

        if (LOG.isDebugEnabled())
        {
            LOG.debug(StringUtil.concat("Resolved resource name to absolute path ", resourcePath));
        }

        InputStream inputStream = caller.getResourceAsStream(resourcePath);

        if (inputStream == null)
        {
            throw new RuntimeException(StringUtil.concat("Could not load relative input stream at ", resourcePath));
        }

        return inputStream;
    }

    /**
     * Loads a relative class resource using Class.getResourceAsInputStream(). The class
     * is determined by the caller object.  The fully qualified path of the resource
     * is determined by the package of the class of the calling object combined with the
     * name of the resource.
     * 
     * @param caller
     * @param name
     * @return
     */
    public static final InputStream relativeInputStream(Object caller, String name)
    {
        if (caller == null)
        {
            throw new IllegalArgumentException("Caller must be supplied");
        }
        return relativeInputStream(caller.getClass(), name);
    }
}
