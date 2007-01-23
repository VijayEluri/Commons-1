/*
 * Created on January 12, 2005 by Collin VanDyck
 */
package com.hannonhill.commons.util;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Utility class for formatting dates for display
 * 
 * @author Collin VanDyck
 * @since  3.x
 */
public class DateFormatter
{

    /**
     * @param date
     * @return
     */
    public static String format(long date)
    {
        return format(new Long(date));
    }

    /**
     * @param date
     * @return
     */
    public static String format(Long date)
    {
        return format(date, null);
    }

    /**
     * @param date
     * @param locale
     * @return
     */
    public static String format(Long date, Locale locale)
    {
        if (date == null)
        {
            return "";
        }
        DateFormat df;
        if (locale == null)
        {
            df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);
        }
        else
        {
            df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT, locale);
        }
        return df.format(date);
    }

    /**
     * Breaks up the input long time into an array
     * of its components: days, hours, minutes,
     * seconds and milliseconds
     *  
     * @param millis
     * @return
     */
    public static int[] toDhms(long millis)
    {
        int[] dhms = new int[5];
        long d = millis / (1000 * 60 * 60 * 24);
        long h = (millis - d * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long m = ((millis - d * (1000 * 60 * 60 * 24)) - h * (1000 * 60 * 60)) / (1000 * 60);
        long s = ((millis - d * (1000 * 60 * 60 * 24)) - h * (1000 * 60 * 60) - m * (1000 * 60)) / 1000;
        long ms = ((millis - d * (1000 * 60 * 60 * 24)) - h * (1000 * 60 * 60) - m * (1000 * 60) - s * (1000));
        dhms[0] = (int) d;
        dhms[1] = (int) h;
        dhms[2] = (int) m;
        dhms[3] = (int) s;
        dhms[4] = (int) ms;
        return dhms;
    }

    /**
     * @param millis
     * @return
     */
    public static String toDhmsString(long millis)
    {
        int[] dhms = toDhms(millis);

        StringBuffer buffer = new StringBuffer(60);

        if (dhms[0] != 0)
        {
            buffer.append(dhms[0] + "d:");
            buffer.append(dhms[1] + "h:");
            buffer.append(dhms[2] + "m:");
            buffer.append(dhms[3] + "s:");
            buffer.append(dhms[4] + "ms");
        }
        else if (dhms[1] != 0)
        {
            buffer.append(dhms[1] + "h:");
            buffer.append(dhms[2] + "m:");
            buffer.append(dhms[3] + "s:");
            buffer.append(dhms[4] + "ms");
        }
        else if (dhms[2] != 0)
        {
            buffer.append(dhms[2] + "m:");
            buffer.append(dhms[3] + "s:");
            buffer.append(dhms[4] + "ms");
        }
        else if (dhms[3] != 0)
        {
            buffer.append(dhms[3] + "s:");
            buffer.append(dhms[4] + "ms");
        }
        else
        {
            buffer.append(dhms[4] + "ms");
        }

        return buffer.toString();
    }

    /**
     * Formats long metadata dates as Strings
     * 
     * @param lDate
     * @return Returns the input long date in String format
     */
    public static String formatMetaDataDate(long lDate)
    {
        Date dThis = new Date(lDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dThis);

        String strDate = getShortDOW(cal.get(Calendar.DAY_OF_WEEK)) + ", " + formatDigit(cal.get(Calendar.DAY_OF_MONTH), 2) + " "
                + getShortMonthName(cal.get(Calendar.MONTH)) + " " + (cal.get(Calendar.YEAR) - 1900);

        String strTime = formatDigit(cal.get(Calendar.HOUR_OF_DAY), 2) + ":" + formatDigit(cal.get(Calendar.MINUTE), 2) + ":"
                + formatDigit(cal.get(Calendar.SECOND), 2) + " ";

        int iOffset = (-(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / (60 * 1000)) - 800;
        if (iOffset < 0)
        {
            strTime += "-";
            iOffset = -iOffset;
        }
        strTime += formatDigit(iOffset, 4);
        return (strDate + " " + strTime);
    }

    /**
     * @param iDigit
     * @param iNumDigits
     * @return
     */
    private static String formatDigit(int iDigit, int iNumDigits)
    {
        return formatDigit(String.valueOf(iDigit), iNumDigits);
    }

    /**
     * @param strDigit
     * @param iNumDigits
     * @return
     */
    private static String formatDigit(String strDigit, int iNumDigits)
    {
        String strToReturn = strDigit;
        for (int i = 0; i < iNumDigits; i++)
        {
            if (new Double(strDigit).doubleValue() < Math.pow(new Double(10).doubleValue(), new Double(i).doubleValue()))
            {
                strToReturn = "0" + strToReturn;
            }
        }
        return strToReturn;
    }

    /**
     * Gets the appreviated String version of the
     * input day of the week
     * 
     * @param iDOW
     * @return Returns a short String for day of the week 
     */
    private static String getShortDOW(int iDOW)
    {
        switch (iDOW)
        {
        case (Calendar.SUNDAY):
            return "Sun";
        case (Calendar.MONDAY):
            return "Mon";
        case (Calendar.TUESDAY):
            return "Tue";
        case (Calendar.WEDNESDAY):
            return "Wed";
        case (Calendar.THURSDAY):
            return "Thu";
        case (Calendar.FRIDAY):
            return "Fri";
        case (Calendar.SATURDAY):
            return "Sat";
        default:
            return "Unknown day of the week";
        }
    }

    /**
     * Converts a integer month to the short String
     * representing that month
     * 
     * @param iMonth
     * @return Returns the String representing the input month
     */
    private static String getShortMonthName(int iMonth)
    {
        switch (iMonth)
        {
        case (Calendar.JANUARY):
            return "Jan";
        case (Calendar.FEBRUARY):
            return "Feb";
        case (Calendar.MARCH):
            return "Mar";
        case (Calendar.APRIL):
            return "Apr";
        case (Calendar.MAY):
            return "May";
        case (Calendar.JUNE):
            return "Jun";
        case (Calendar.JULY):
            return "Jul";
        case (Calendar.AUGUST):
            return "Aug";
        case (Calendar.SEPTEMBER):
            return "Sep";
        case (Calendar.OCTOBER):
            return "Oct";
        case (Calendar.NOVEMBER):
            return "Nov";
        case (Calendar.DECEMBER):
            return "Dec";
        default:
            return "Unknown month";
        }
    }
}