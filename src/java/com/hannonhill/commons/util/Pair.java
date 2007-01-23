package com.hannonhill.commons.util;

/**
 * Represents a pair of something.
 *
 * @author Collin VanDyck
 * @since 4.5
 */
public class Pair<A, B>
{
    private A left;
    private B right;

    /**
     * Constructor.
     * 
     * @param left
     * @param right
     */
    public Pair(A left, B right)
    {
        this.left = left;
        this.right = right;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Pair)
        {
            Pair<A, B> pair = (Pair) obj;

            if (!EqualsUtil.equal(left, pair.left))
            {
                return false;
            }
            if (!EqualsUtil.equal(right, pair.right))
            {
                return false;
            }
            return true;
        }
        return false;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        int hashCode = 0;
        if (left != null)
        {
            hashCode += left.hashCode();
        }
        if (right != null)
        {
            hashCode += right.hashCode();
        }
        return hashCode;
    }

    /**
     * @return the left
     */
    public final A getLeft()
    {
        return left;
    }

    /**
     * @return the right
     */
    public final B getRight()
    {
        return right;
    }

}
