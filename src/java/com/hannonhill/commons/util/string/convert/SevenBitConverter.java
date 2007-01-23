/*
 * Created on Apr 6, 2005
 *
 */
package com.hannonhill.commons.util.string.convert;

import org.apache.log4j.Logger;

/**
 * Handles the conversion of UNICODE input to the 7-bit ASCII equivalent.
 * 
 * @author Collin VanDyck
 * @since 4.x
 */
public class SevenBitConverter implements StringConvert
{
    private static final Logger LOG = Logger.getLogger(SevenBitConverter.class);

    /* (non-Javadoc)
     * @see com.hannonhill.util.string.convert.StringConvert#convert(java.lang.String)
     */
    public String convert(String input) throws StringConvertException
    {
        if (input == null)
            return null;

        final StringBuilder builder = new StringBuilder(input.length() * 2);

        final char[] chars = input.toCharArray();
        for (int idx = 0, n = chars.length; idx < n; idx++)
        {
            final char ch = chars[idx];
            final int intch = (int) ch;

            if (intch > 127)
            {
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("Got extended character '" + ch + "' with value " + (int) ch);
                }
                builder.append("&#");
                builder.append(intch);
                builder.append(";");
            }
            else
            {
                builder.append(ch);
            }
        }

        return builder.toString();
    }

}
