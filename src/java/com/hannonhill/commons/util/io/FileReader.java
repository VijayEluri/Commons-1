/*
 * Created on Jul 22, 2004
 *
 */
package com.hannonhill.commons.util.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

/**
 * Reads from a file and returns its contents.
 * 
 * @author Collin VanDyck
 * @since  1.0
 */
public class FileReader
{

    private File file;

    /**
     * Default constructor. 
     */
    public FileReader(File file) throws IOException
    {
        if (file == null)
        {
            throw new IOException("Received blank file as input to constructor");
        }
        this.file = file;
    }

    /**
     * Reads from the File (51K at a time) and 
     * returns its contents as a String
     * 
     * @return
     * @throws IOException
     */
    public String readFileAsCharacterData() throws IOException
    {
        final int bufsize = 51200;
        char[] buffer = new char[bufsize];
        int charsRead;
        StringWriter stringWriter = new StringWriter();
        BufferedReader inReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        BufferedWriter outWriter = new BufferedWriter(stringWriter);

        while ((charsRead = inReader.read(buffer, 0, bufsize)) >= 0)
        {
            outWriter.write(buffer, 0, charsRead);
        }

        outWriter.flush();
        inReader.close();
        return stringWriter.toString();
    }
}
