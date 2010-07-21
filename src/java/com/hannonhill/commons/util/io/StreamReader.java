/*
 * Created on October 7, 2005 by Collin VanDyck
 */
package com.hannonhill.commons.util.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.hannonhill.commons.util.StringUtil;

/**
 * Utility class to help read from InputStreams
 *  
 * @author  Collin VanDyck
 * @version $Id: StreamReader.java 5409 2007-01-22 22:59:51Z bradley.wagner $
 * @since   1.0 
 */
public class StreamReader
{

    private InputStream input;

    /**
     * Static convenience method to read an input stream as string data. Will not
     * close the input stream.
     * 
     * @param is
     * @return
     * @throws IOException
     */
    public static String read(InputStream is) throws IOException
    {
        StreamReader reader = new StreamReader(is);
        return reader.readAsString();
    }

    /**
     * Constructor.
     * @param input
     */
    public StreamReader(InputStream input)
    {
        this.input = input;
    }

    /**
     * Reads the input stream and returns the String data
     * 
     * @return
     * @throws IOException
     */
    public String readAsString() throws IOException
    {
        byte[] bytes = readAsByteArray();
        return StringUtil.toString(bytes);
    }

    /**
     * Reads the input stream and returns it as a byte array containing all data that could be read from the stream.
     * 
     * @return
     * @throws IOException
     */
    public byte[] readAsByteArray() throws IOException
    {
        int bufsize = 4096;
        byte[] buffer = new byte[bufsize];
        int bytesread = 0;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while ((bytesread = input.read(buffer, 0, bufsize)) >= 0)
        {
            out.write(buffer, 0, bytesread);
        }

        return out.toByteArray();
    }
}
