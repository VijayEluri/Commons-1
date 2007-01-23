/*
 * Created on Mar 1, 2005
 */
package com.hannonhill.commons.util.io;

import java.io.File;

/**
 * Deletes directories.
 * 
 * @author Collin VanDyck
 * @since  1.0
 */
public class DirectoryDeleter
{

    /**
     * Deletes a directory.
     * 
     * @param directory
     * @throws Exception
     */
    public static void delete(File directory) throws Exception
    {
        if (!directory.exists())
        {
            return;
        }

        if (!directory.isDirectory())
        {
            return;
        }

        final File[] children = directory.listFiles();
        for (int idx = 0; idx < children.length; idx++)
        {
            final File child = children[idx];
            if (child.isDirectory())
            {
                delete(child);
            }
            if (!child.delete())
            {
                throw new Exception("Folder " + child.getAbsolutePath() + " could not be deleted");
            }

        }

        if (!directory.delete())
        {
            throw new Exception("Folder " + directory.getAbsolutePath() + " could not be deleted");
        }
    }

}
