/*
 * Created on Sep 28, 2004
 */
package com.hannonhill.commons.util.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A List implementation that keeps a certain number of items.  As
 * the capacity is reached, the oldest items will be released out of the
 * list.
 * 
 * @author  Collin VanDyck
 * @version $Id: LimitedCapacityQueueList.java 5205 2006-11-29 20:59:24Z bradley.wagner $
 * @since   3.x
 */
public class LimitedCapacityQueueList<T>
{

    private int maxCapacity;
    private List<T> list;

    public LimitedCapacityQueueList(int capacity)
    {
        if (capacity <= 0)
        {
            throw new RuntimeException("Cannot have negative capacity");
        }
        this.maxCapacity = capacity;
        this.list = new ArrayList<T>(capacity);
    }

    /**
     * @param object
     * @return
     */
    public boolean add(T object)
    {
        list.add(0, object);

        // trim the list if necessary.
        final int listSize = list.size();
        if (listSize > maxCapacity)
        {
            list.remove(listSize - 1);
        }

        return true;
    }

    /**
     * 
     */
    public void clear()
    {
        list.clear();
    }

    /**
     * @param o
     * @return
     */
    public boolean contains(T o)
    {
        return list.contains(o);
    }

    /**
     * @param c
     * @return
     */
    public boolean containsAll(Collection<T> c)
    {
        return list.containsAll(c);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        return list.equals(obj);
    }

    /**
     * @param index
     * @return
     */
    public T get(int index)
    {
        return list.get(index);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        return list.hashCode();
    }

    /**
     * @param o
     * @return
     */
    public int indexOf(T o)
    {
        return list.indexOf(o);
    }

    /**
     * @return
     */
    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    /**
     * @return
     */
    public Iterator<T> iterator()
    {
        return list.iterator();
    }

    /**
     * @param o
     * @return
     */
    public int lastIndexOf(T o)
    {
        return list.lastIndexOf(o);
    }

    /**
     * @return
     */
    public ListIterator<T> listIterator()
    {
        return list.listIterator();
    }

    /**
     * @param index
     * @return
     */
    public ListIterator listIterator(int index)
    {
        return list.listIterator(index);
    }

    /**
     * @param index
     * @return
     */
    public T remove(int index)
    {
        return list.remove(index);
    }

    /**
     * @param o
     * @return
     */
    public boolean remove(T o)
    {
        return list.remove(o);
    }

    /**
     * @param c
     * @return
     */
    public boolean removeAll(Collection<T> c)
    {
        return list.removeAll(c);
    }

    /**
     * @param c
     * @return
     */
    public boolean retainAll(Collection<T> c)
    {
        return list.retainAll(c);
    }

    /**
     * @param index
     * @param element
     * @return
     */
    public T set(int index, T element)
    {
        return list.set(index, element);
    }

    /**
     * @return
     */
    public int size()
    {
        return list.size();
    }

    /**
     * @param fromIndex
     * @param toIndex
     * @return
     */
    public List<T> subList(int fromIndex, int toIndex)
    {
        return list.subList(fromIndex, toIndex);
    }

    /**
     * @return
     */
    public T[] toArray(T[] a)
    {
        return list.toArray(a);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return list.toString();
    }
}