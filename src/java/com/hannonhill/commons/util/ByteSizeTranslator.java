/*
 * Created on Aug 26, 2004
 *
 */
package com.hannonhill.commons.util;

/**
 * Means to convert byte sizes into human readable strings.
 * 
 * @author Collin VanDyck
 * @since  1.0
 */
public class ByteSizeTranslator
{

    private int size;

    /**
     * Constructor.
     */
    public ByteSizeTranslator(int size)
    {
        super();
        this.size = size;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return convert();
    }

    /**
     * @return
     */
    private String convert()
    {
        StringBuffer buffer = new StringBuffer();

        double kilobytes = this.size / 1024.00;

        if (kilobytes < 1)
        {
            buffer.append(this.size);
            buffer.append(" B");
        }
        else if (kilobytes < 1000)
        {
            buffer.append(formatDouble(kilobytes));
            buffer.append(" KB");
        }
        else
        {
            // convert to megs.
            double megabytes = kilobytes / 1000;

            buffer.append(formatDouble(megabytes));
            buffer.append(" MB");
        }

        return buffer.toString();
    }

    /**
     * @param number
     * @return
     */
    private String formatDouble(double number)
    {
        try
        {
            String num = String.valueOf(number);
            int pos = num.indexOf('.');
            if (pos >= 0)
            {
                int stringLength = num.length();
                if (stringLength > pos + 3)
                {
                    return num.substring(0, pos + 3);
                }
            }
            return num;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return String.valueOf(number);
        }
    }
}