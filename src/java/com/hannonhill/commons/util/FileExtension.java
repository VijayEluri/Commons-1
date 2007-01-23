/*
 * Created on Apr 5, 2004
 */
package com.hannonhill.commons.util;

import org.apache.log4j.Logger;

/**
 * Provides utility methods to help determine the extension of file names. This
 * may also be applied to asset names.
 *  
 * @author Collin VanDyck
 * @since  1.0
 */
public final class FileExtension
{

    private static final Logger LOG = Logger.getLogger(FileExtension.class);

    private String name;
    private String baseName;
    private String extension;
    private int extensionIndex;
    private boolean preservePeriod; // if we want the . in front of the extension.

    /**
     * Constructor
     * 
     * @param name
     */
    public FileExtension(String name)
    {
        setName(name);
    }

    /**
     * @param name the name to set
     */
    public final void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return true if the filename has an extension
     */
    public boolean hasExtension()
    {
        process();
        return (extension != null);
    }

    /**
     * @return the extension of the filename
     */
    public final String getExtension()
    {
        process();
        return extension;
    }

    private boolean processed;

    /**
     * Extracts the extension from the name and stores it.
     *  
     */
    private void process()
    {
        if (processed)
            return;

        final String name = this.name;
        if (name != null)
        {
            extensionIndex = name.lastIndexOf(".");

            LOG.debug("grabExtension: got index " + extensionIndex + " for name " + name);

            if (extensionIndex >= 0)
            {
                if (preservePeriod)
                {
                    extension = name.substring(extensionIndex);

                    int endIndex = extensionIndex - 1;
                    if (endIndex < 0)
                    {
                        endIndex = 0;
                    }

                    baseName = name.substring(0, endIndex);

                    LOG.debug("grabExtension: preserving period, got base " + baseName + " , extension " + extension);
                }
                else
                {
                    extension = name.substring(extensionIndex + 1);
                    baseName = name.substring(0, extensionIndex);

                    LOG.debug("grabExtension: not preserving period, got base " + baseName + " , extension " + extension);
                }

                LOG.debug("grabExtension: baseName derived to be " + baseName);
            }
            else
            {
                baseName = name;
            }
        }

        processed = true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object)
    {
        if (object instanceof FileExtension)
        {
            final FileExtension fileExtension = (FileExtension) object;
            if (this.extension == null)
            {
                return fileExtension.extension == null;
            }
            return extension.equals(fileExtension.extension);
        }
        return super.equals(object);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        if (extension == null)
        {
            return 0;
        }
        return extension.hashCode();
    }

    /**
     * @return Returns the baseName.
     */
    public String getBaseName()
    {
        process();
        return baseName;
    }

    /**
     * @param preservePeriod The perservePeriod to set.
     */
    public void setPreservePeriod(boolean preservePeriod)
    {
        this.preservePeriod = preservePeriod;
    }
}
