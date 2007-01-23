/*
 * Created on Apr 8, 2005
 * 
 */
package com.hannonhill.commons.util;

import junit.framework.TestCase;

import com.hannonhill.commons.util.BitWise;

/**
 * Test the methods of the BitWise utility class
 * 
 * @author Bradley Wagner
 * @since  1.0
 */
public class TestBitWise extends TestCase
{

    public void testBitSet()
    {
        int testInt = 5;
        assertTrue(BitWise.bitSet(testInt, 1));
        assertTrue(BitWise.bitSet(testInt, 4));
        assertFalse(BitWise.bitSet(testInt, 2));
    }

    public void testStringtoIntTranslate()
    {
        assertTrue(BitWise.translate(null) == 0);

        String[] empty = {};
        assertTrue(BitWise.translate(empty) == 0);

        String[] one =
        {
            "1"
        };
        assertTrue(BitWise.translate(one) == 1);

        String[] twentyseven =
        {
                "1", "2", "8", "16"
        };
        assertTrue(BitWise.translate(twentyseven) == 27);
    }

    public void testIntToStringTranslate()
    {
        assertTrue(BitWise.translate(0).length == 0);

        String[] result = BitWise.translate(27);
        String[] twentyseven =
        {
                "1", "2", "8", "16"
        };

        assertTrue(result.length == twentyseven.length);

        for (int i = 0; i < result.length; i++)
        {
            assertTrue(result[i].equals(twentyseven[i]));
        }
    }

    public void testCongruentTranslate()
    {
        for (int i = 0; i < 1000; i++)
        {
            int random = (int) (Math.random() * 128);
            assertTrue(BitWise.translate(BitWise.translate(random)) == random);
        }
    }
}
