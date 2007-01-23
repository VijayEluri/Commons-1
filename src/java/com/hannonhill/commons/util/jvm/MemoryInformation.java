/*
 * Created on October 8, 2005 by Collin VanDyck 
 */
package com.hannonhill.commons.util.jvm;

/**
 * Object for determining JVM runtime memory statistics
 * 
 * @author  Collin VanDyck
 * @version $Id: MemoryInformation.java 5410 2007-01-22 23:26:52Z bradley.wagner $
 * @since   1.0
 */
public class MemoryInformation
{

    private long freeMemory;
    private long maxMemory;
    private long totalMemory;
    private long usedMemory;

    /**
     * Constructor
     * 
     * Builds the information.
     */
    public MemoryInformation()
    {
        Runtime runtime = Runtime.getRuntime();
        setFreeMemory(runtime.freeMemory());
        setMaxMemory(runtime.maxMemory());
        setTotalMemory(runtime.totalMemory());

        setUsedMemory(getTotalMemory() - getFreeMemory());
    }

    /**
     * @return Returns the freeMemory.
     */
    public long getFreeMemory()
    {
        return freeMemory;
    }

    /**
     * @param freeMemory The freeMemory to set.
     */
    public void setFreeMemory(long freeMemory)
    {
        this.freeMemory = freeMemory;
    }

    /**
     * @return Returns the maxMemory.
     */
    public long getMaxMemory()
    {
        return maxMemory;
    }

    /**
     * @param maxMemory The maxMemory to set.
     */
    public void setMaxMemory(long maxMemory)
    {
        this.maxMemory = maxMemory;
    }

    /**
     * @return Returns the totalMemory.
     */
    public long getTotalMemory()
    {
        return totalMemory;
    }

    /**
     * @param totalMemory The totalMemory to set.
     */
    public void setTotalMemory(long totalMemory)
    {
        this.totalMemory = totalMemory;
    }

    /**
     * @return Returns the usedMemory.
     */
    public long getUsedMemory()
    {
        return usedMemory;
    }

    /**
     * @param usedMemory The usedMemory to set.
     */
    public void setUsedMemory(long usedMemory)
    {
        this.usedMemory = usedMemory;
    }

    /**
     * @return the string version of the xml representing the memory data
     */
    public String toXML()
    {
        StringBuffer result = new StringBuffer(500);
        result.append("<memory>");
        result.append("<free-memory>" + freeMemory + "</free-memory>");
        result.append("<max-memory>" + maxMemory + "</max-memory>");
        result.append("<total-memory>" + totalMemory + "</total-memory>");
        result.append("<used-memory>" + usedMemory + "</used-memory>");
        result.append("</memory>");
        return result.toString();
    }
}