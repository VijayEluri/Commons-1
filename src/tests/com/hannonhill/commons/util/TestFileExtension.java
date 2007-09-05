/*
 * Created on Apr 7, 2005
 *
 */
package com.hannonhill.commons.util;

import com.hannonhill.commons.util.FileExtension;
import com.hannonhill.commons.util.StringUtil;
import com.hannonhill.commons.junit.HHTestCase;

/**
 * Test for the FileExtension class.
 *  
 * @author Collin VanDyck
 */
public class TestFileExtension extends HHTestCase
{

    private static final String NORMAL_FILENAME = "image.jpg";
    private static final String HIDDEN_FILENAME = ".htaccess";

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }

    /**
     * Ensures that the extension is reported
     */
    public void testHasExtension()
    {
        FileExtension extension = new FileExtension(NORMAL_FILENAME);
        assertTrue(extension.hasExtension());
    }

    /**
     * Ensures that the extension is reported correctly
     */
    public void testGetExtension()
    {
        FileExtension extension = new FileExtension(NORMAL_FILENAME);
        String extString = extension.getExtension();
        assertEquals("jpg", extString);
    }

    /**
     * Tests to see if the base name can be extracted
     */
    public void testGetBaseName()
    {
        FileExtension extension = new FileExtension(NORMAL_FILENAME);
        String baseName = extension.getBaseName();
        assertEquals("image", baseName);
    }

    /**
     * Tests to see if the base name can be extracted after getting the extension.
     */
    public void testGetBaseNameAfterGettingExtension()
    {
        FileExtension extension = new FileExtension(NORMAL_FILENAME);
        String extensionName = extension.getExtension();
        assertEquals("jpg", extensionName);
        String baseName = extension.getBaseName();
        assertEquals("image", baseName);
    }

    /**
     * Ensures that a hidden file is still reported correctly
     */
    public void testHiddenFilename()
    {
        // first test, and do not preserve the '.'
        FileExtension fileExtension = new FileExtension(HIDDEN_FILENAME);
        fileExtension.setPreservePeriod(false);
        String base = fileExtension.getBaseName();
        String extension = fileExtension.getExtension();

        assertTrue(StringUtil.isEmpty(base));
        assertTrue(fileExtension.hasExtension());
        assertTrue("htaccess".equals(extension));

        // next test, and preserve the '.'
        fileExtension = new FileExtension(HIDDEN_FILENAME);
        fileExtension.setPreservePeriod(true);
        base = fileExtension.getBaseName();
        extension = fileExtension.getExtension();

        assertTrue(StringUtil.isEmpty(base));
        assertTrue(fileExtension.hasExtension());
        assertTrue(".htaccess".equals(extension));
    }
    
    public void testPreservePeriod() throws Exception
    {
        FileExtension ext = new FileExtension(NORMAL_FILENAME);
        ext.setPreservePeriod(true);
        String base = ext.getBaseName();
        String extension = ext.getExtension();
        assertEquals("image", base);
        assertEquals(".jpg", extension);
    }
}
