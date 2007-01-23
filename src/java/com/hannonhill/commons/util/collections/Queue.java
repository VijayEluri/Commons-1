/*
 * Created on Apr 5, 2004
 *
 */
package com.hannonhill.commons.util.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Simple implementation of a Queue.
 * 
 * @author  Collin VanDyck
 * @version $Id: Queue.java 5197 2006-11-28 01:47:00Z bradley.wagner $
 * @since   3.x
 */
public class Queue<T>  {
	
	private List<T> list;
	
	/**
	 * Default constructor for default collection capacity.
	 */
	public Queue()
	{
	    list = new ArrayList<T>();
	}

	/**
	 * Constructor that allows initialCapacity to be set.
	 * 
	 * @param initialCapacity
	 */
	public Queue(int initialCapacity)
	{
	    list = new ArrayList<T>(initialCapacity);
	}
	
	/**
	 * Puts an object at the end of the queue.
	 * 
	 * @param obj
	 */
	public void put(T obj) 
	{
		this.list.add(obj);
	}
	
	/**
	 * Inserts an object at the head of the queue.
	 * 
	 * @param obj
	 */
	public final void insert(T obj)
	{
	    this.list.add(0,obj);
	}
	
	/**
	 * Inserts a collection of items at the head of the queue.
	 * 
	 * @param stuff
	 */
	public final void insert(Collection<T> stuff)
	{
	    this.list.addAll(0,stuff);
	}
	
	/**
	 * Puts a collection of items at the end of the queue.
	 * 
	 * @param stuff
	 */
	public final void put(Collection<T> stuff) 
	{
		this.list.addAll(stuff);
	}
	
	/**
	 * Fetches an object from the head of the queue, and removes that
	 * object from the queue.
	 * 
	 * @return the object at the head of the list. Null if the queue is empty.
	 */
	public T get() 
	{
		if (isEmpty()) {
			return null;
		}
		return this.list.remove(0);
	}
	
	/**
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() 
	{
		return this.list.size() == 0;
	}
	
	/**
	 * @return false if empty, true otherwise.
	 */
	public boolean hasMore()
	{
	    return !isEmpty();
	}
	
    /**
     * Tells whether or not the queue contains an object.
     * 
     * @param arg0 the object to test for.
     * @return true if the queue contains arg0
     */
    public boolean contains(T arg0)
    {
        return list.contains(arg0);
    }
    
    /**
     * @return the size of the queue.
     */
    public int size()
    {
        return list.size();
    }
}
