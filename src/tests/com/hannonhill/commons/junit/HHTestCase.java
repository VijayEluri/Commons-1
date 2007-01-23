/*
 * Created on Apr 26, 2005
 *
 */
package com.hannonhill.commons.junit;

import java.io.InputStream;

import junit.framework.TestCase;

import org.apache.log4j.BasicConfigurator;

import com.hannonhill.commons.util.io.StreamReader;

/**
 * Base class for HannonHill test cases.
 * 
 * @author Collin VanDyck
 */
public abstract class HHTestCase extends TestCase
{

    /**
     * Constructor that takes no name. 
     */
    public HHTestCase()
    {
        super();
    }

    /**
     * Constructor that names the test case.
     * 
     * @param testCaseName the name of the test case
     */
    public HHTestCase(String testCaseName)
    {
        super(testCaseName);
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        this.initializeLog4j();
    }

    /**
     * Does basic log4j configuration so that WARNs are not appended to the console.
     */
    protected void initializeLog4j()
    {
        BasicConfigurator.resetConfiguration();
        BasicConfigurator.configure();
    }

    /**
     * Reads a class resource as a stirng.
     * 
     * @param path
     * @param klass
     * @return
     */
    protected String readString(String path, Class klass) throws Exception
    {
        InputStream in = klass.getResourceAsStream(path);
        try
        {
            StreamReader reader = new StreamReader(in);
            return reader.readAsString();
        }
        finally
        {
            in.close();
        }
    }

    /**
     * Logs a message to standard out.
     * 
     * @param obj the message
     */
    protected void info(Object obj)
    {
        System.out.println(obj.toString());
    }

    /**
     * Logs a message to standard error.
     * 
     * @param obj the message
     */
    protected void error(Object obj)
    {
        System.err.print(obj.toString());
    }
}