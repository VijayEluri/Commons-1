/*
 * Created on Apr 7, 2005
 *
 */
package com.hannonhill.commons.util;

import com.hannonhill.commons.util.StringUtil;
import com.hannonhill.commons.junit.HHTestCase;


/**
 * Unit tests for the StringUtil class.
 * 
 * @author Collin VanDyck
 */
public class TestStringUtil extends HHTestCase {

    /**
     * Constructor that takes a name.
     * 
     * @param test
     */
    public TestStringUtil(String test)
    {
        super(test);
    }

    /**
     * Tests the is not empty trimmed method
     */
    public void testIsNotEmptyTrimmed() 
    {
        assertTrue(StringUtil.isNotEmptyTrimmed("abc"));
        assertTrue(StringUtil.isNotEmptyTrimmed("a"));
        
        assertFalse(StringUtil.isNotEmptyTrimmed(""));
        assertFalse(StringUtil.isNotEmptyTrimmed(null));
        assertFalse(StringUtil.isNotEmptyTrimmed("   "));
    }
    
    public void testStringEmpty()
    {
        String emptyString = null;
        assertTrue(StringUtil.isEmpty(emptyString));
        
        emptyString = "";
        assertTrue(StringUtil.isEmpty(emptyString));
        
        emptyString = " ";
        assertFalse(StringUtil.isEmpty(emptyString));
    }

    public void testIsEmptyTrimmed()
    {
        String untrimmed = null;
        assertTrue(StringUtil.isEmptyTrimmed(untrimmed));
        
        untrimmed = "";
        assertTrue(StringUtil.isEmptyTrimmed(untrimmed));
        
        untrimmed = "   ";
        assertTrue(StringUtil.isEmptyTrimmed(untrimmed));
        
    }

    public void testSubString()
    {
        String base = "Cascade Server";
        
        String substring = StringUtil.subString(base,1);
        assertEquals("C",substring);
        
        substring = StringUtil.subString(base,0);
        assertEquals("",substring);
        
        substring = StringUtil.subString(base,1000);
        assertEquals(substring,base);
    }
    
    public void testToProperCase()
    {
        String base = "cASCADE";
        String fixed = StringUtil.toProperCase(base);
        assertEquals("Cascade",fixed);
        
        base = "cascade";
        fixed = StringUtil.toProperCase(base);
        assertEquals("Cascade",fixed);
        
        base = "";
        fixed = StringUtil.toProperCase(base);
        assertEquals("",fixed);
        
        base = null;
        fixed = StringUtil.toProperCase(base);
        assertNull(fixed);
        
    }
    
    /**
     * Tests to make sure leading characters are removed appropriately.
     */
    public void testRemoveLeadingCharacters()
    {
        String inputString = "***Success";
        char testChar = '*';
        
        assertEquals("Success",StringUtil.removeLeadingCharacters(inputString,testChar));
        
        inputString = "Success";
        assertEquals("Success",StringUtil.removeLeadingCharacters(inputString,testChar));
        
        inputString = "";
        assertEquals("",StringUtil.removeLeadingCharacters(inputString,testChar));
        
        inputString= "***";
        assertEquals("", StringUtil.removeLeadingCharacters(inputString,testChar));
        
        inputString = "Success*";
        assertEquals("Success*",StringUtil.removeLeadingCharacters(inputString,testChar));
        
    }
    
    /**
     * Tests to make sure trailing characters are removed correctly/
     */
    public void testRemoveTrailingCharacters()
    {
        String inputString = "Success***";
        char testChar = '*';
        
        assertEquals("Success",StringUtil.removeTrailingCharacters(inputString,testChar));
        
        inputString = "Success";
        assertEquals("Success",StringUtil.removeTrailingCharacters(inputString,testChar));
        
        inputString = "";
        assertEquals("",StringUtil.removeTrailingCharacters(inputString,testChar));
        
        inputString = "***Success";
        assertEquals("***Success",StringUtil.removeTrailingCharacters(inputString,testChar));
        
        inputString = "***";
        assertEquals("",StringUtil.removeTrailingCharacters(inputString,testChar));
    }
    
    public void testRemoveWhitespace()
    {
        assertEquals("", StringUtil.removeWhitespace("  \r   \t  \t \t   \n  "));
        assertEquals("", StringUtil.removeWhitespace("     \t  \t \t     "));
        
        assertEquals("abcd", StringUtil.removeWhitespace("\r\r\r\n\n\n  \r\n  a\t \t  b  \t cd"));
        assertEquals("abcd", StringUtil.removeWhitespace(" \r\r  a\t \t  b  \t c\n\nd"));    
    }
    
}
