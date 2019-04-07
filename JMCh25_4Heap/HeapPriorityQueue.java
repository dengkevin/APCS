import java.util.*;

/**
   Implements a priority queue based on a min-heap.

   @author  TODO Kevin Deng
   @version 3/7/19

   @author Period - TODO 3/7/19
   @author Assignment - TODO Assignment Name

   @author Sources - TODO list collaborators
 */
public class HeapPriorityQueue
{
    private static final int DFLT_CAPACITY = 101;
    private Object[] items;
    private int numItems;
    private final Comparator<Object> comparator;

    public HeapPriorityQueue()
    {
        this(DFLT_CAPACITY, null);
    }

    public HeapPriorityQueue(Comparator<Object> c)
    {
        this(DFLT_CAPACITY, c);
    }

    public HeapPriorityQueue(int initialCapacity)
    {
        this(initialCapacity, null);
    }

    public HeapPriorityQueue(int initialCapacity, Comparator<Object> c)
    {
        items = new Object[initialCapacity + 1];
        comparator = c;
    }

    /**
     *  Returns true if this priority queue is empty;
     *  otherwise returns false.
     */
    public boolean isEmpty()
    {
        return numItems == 0;
    }

    /**
     *  Returns the highest priority element without removing
     *  it from this priority queue.
     */
    public Object peek()
    {
        if (numItems == 0)
        {
            throw new NoSuchElementException();
        }
        return items[1];
    }

    /**
     *  Adds obj to this priority queue; returns true.
     */
    public boolean add(Object obj)
    {
        numItems++;
        if (numItems >= items.length)  // items[0] is not used
            growCapacity();
        items[numItems] = obj;
        reheapUp();
        return true;
    }

    /**
     *  Removes and returns the highest priority item.
     */
    public Object remove()
    {
        if (numItems == 0)
        {
            throw new NoSuchElementException();
        }

        Object minObject = items[1];
        items[1] = items[numItems];
        numItems--;
        reheapDown();
        return minObject;
    }

    //**************************************************************************

    private boolean lessThan(Object obj1, Object obj2)
    {
        if (comparator != null)
            return comparator.compare(obj1, obj2) < 0;
        else
            return ((Comparable)obj1).compareTo(obj2) < 0;
    }

    public void reheapDown()
    {
        if (numItems <= 1)
        {
            return;
        }
        else
        {
            int position = 1; //starting position
            int newPos = 0;
            while (position * 2 <= numItems && position * 2 + 1 <= numItems)
            {
                if (lessThan(items[position * 2], items[position * 2 + 1]))
                {
                    newPos = position * 2;
                }
                else
                {
                    newPos = position * 2 + 1;
                }
                
                Object o = items[position];
                items[position] = items[newPos];
                items[newPos] = o;
                position = newPos;
            }
            if (position * 2 <= numItems && lessThan(items[position * 2], items[position]))
            {
                newPos = position * 2;
                Object o = items[position];
                items[position] = items[newPos];
                items[newPos] = o;
                position = newPos;
            }
        }
    }

    public void reheapUp()
    {
        if (numItems <= 1)
        {
            return;
        }
        else
        {
            int itemCount = numItems;
            
            while (items[itemCount / 2] != null && lessThan(items[itemCount], items[itemCount / 2]))
            {
                Object o = items[itemCount];
                items[itemCount] = items[itemCount / 2];
                items[itemCount / 2] = o;
                itemCount /= 2;
            }
        }
    }

    private void growCapacity()
    {
        Object[] tempItems = new Object[2 * items.length - 1];
        System.arraycopy(items, 0, tempItems, 0, items.length);
        items = tempItems;
    }

    /**
    returns the String containing all the elements in level order
    @return the String containing all the elements in level order
     */
    public String toString()
    {
        String toReturn = "";
        for (int i = 1; i <= numItems; i++)
        {
            toReturn += items[i] + "\n";
        }
        return toReturn;
    }
}

