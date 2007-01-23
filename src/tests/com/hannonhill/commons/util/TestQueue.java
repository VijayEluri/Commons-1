/*
 * Created on Apr 7, 2005
 */
package com.hannonhill.commons.util;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import com.hannonhill.commons.util.collections.Queue;

/**
 * Test of the com.hannonhill.util.Queue class.
 * 
 * @author Collin VanDyck
 */
public class TestQueue extends TestCase
{
    private static final String FRED = "fred";
    private static final String MARY = "mary";
    private static final String JANE = "jane";

    /*
     * @see TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }

    /*
     * @see TestCase#tearDown()
     */
    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    /**
     * Constructor for TestQueue.
     * @param name
     */
    public TestQueue(String name)
    {
        super(name);
    }

    /*
     * Class under test for void insert(Object)
     */
    public void testInsertObject()
    {
        Queue<String> queue = new Queue<String>();
        assertEquals(0, queue.size());

        queue.insert(MARY);
        assertEquals(1, queue.size());

        assertEquals(MARY, queue.get());
        assertEquals(0, queue.size());
    }

    /*
     * Class under test for void insert(Collection)
     */
    public void testInsertCollection()
    {
        Queue<String> queue = new Queue<String>();

        queue.insert("");

        Collection<String> names = new ArrayList<String>();
        names.add(MARY);
        names.add(FRED);
        names.add(JANE);

        assertEquals(1, queue.size());

        queue.insert(names);

        assertEquals(4, queue.size());
        assertEquals(MARY, queue.get());

        assertEquals(3, queue.size());
        assertEquals(FRED, queue.get());

        assertEquals(2, queue.size());
        assertEquals(JANE, queue.get());

        assertEquals(1, queue.size());
        assertEquals("", queue.get());

        assertEquals(0, queue.size());
    }

    /*
     * Class under test for void put(Collection)
     */
    public void testPutCollection()
    {
        Queue<String> queue = new Queue<String>();

        queue.insert("");

        Collection<String> names = new ArrayList<String>();
        names.add(MARY);
        names.add(FRED);
        names.add(JANE);

        assertEquals(1, queue.size());

        queue.put(names);

        assertEquals(4, queue.size());
        assertEquals("", queue.get());

        assertEquals(3, queue.size());
        assertEquals(MARY, queue.get());

        assertEquals(2, queue.size());
        assertEquals(FRED, queue.get());

        assertEquals(1, queue.size());
        assertEquals(JANE, queue.get());

        assertEquals(0, queue.size());
    }

    public void testGet()
    {
        Queue<String> queue = new Queue<String>();
        queue.put(FRED);
        queue.put(MARY);

        assertEquals(FRED, queue.get());
        assertEquals(MARY, queue.get());
        assertNull(queue.get());
    }

    public void testIsEmpty()
    {
        Queue<String> queue = new Queue<String>();
        assertTrue(queue.isEmpty());

        queue.put(MARY);
        assertFalse(queue.isEmpty());

        queue.get();
        assertTrue(queue.isEmpty());
    }

    public void testHasMore()
    {
        Queue<String> queue = new Queue<String>();

        queue.put(MARY);
        queue.put(FRED);

        assertTrue(queue.hasMore());
        queue.get();
        assertTrue(queue.hasMore());
        queue.get();
        assertFalse(queue.hasMore());
    }

    public void testContains()
    {
        Queue<String> queue = new Queue<String>();
        queue.put(FRED);
        queue.put(JANE);

        assertFalse(queue.contains(MARY));
        assertTrue(queue.contains(FRED));
        assertTrue(queue.contains(JANE));

        assertEquals(FRED, queue.get());

        assertFalse(queue.contains(FRED));
        assertTrue(queue.contains(JANE));
    }

    public void testSize()
    {
        Queue<String> queue = new Queue<String>();

        assertEquals(0, queue.size());

        queue.put(FRED);
        assertEquals(1, queue.size());

        queue.get();
        assertEquals(0, queue.size());
    }
}