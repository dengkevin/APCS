import java.util.Iterator;

/**
    Implements a singly-linked list.
    
    @author  TODO Kevin Deng
    @version TODO 12/09/18
    
    @author  Period - TODO 3
    @author  Assignment - TODO SinglyLinkedList
    
    @author  Sources - Maria & Gary Litvin
 */
public class SinglyLinkedList<E> implements Iterable<E>
{
    private ListNode<E> head;
    private int nodeCount;

    // Constructor: creates an empty list
    public SinglyLinkedList()
    {
        head = null;
        nodeCount = 0;
    }

    /**
        Constructor: creates a list that contains all elements from the
        array values, in the same order
        @param values  array containing all elements for this list
     */
    public SinglyLinkedList(E[] values)
    {
        ListNode<E> tail = null;
        for (E value : values) // for each value to insert
        {
            ListNode<E> node = new ListNode<E>(value, null);
            if (head == null)
                head = node;
            else
                tail.setNext(node);
            tail = node;    // update tail
        }

        nodeCount = values.length;
    }

    /**
        Return true if this list is empty; otherwise returns false.
        @return true if this list is empty; otherwise returns false.
     */
    public boolean isEmpty()
    {
        if (head == null)
        {
            return true;
        }
        return false;
    }

    /**
        Returns the number of elements in this list.
        @return  number of elements in this list.
     */
    public int size()
    {
        return nodeCount;
    }

    /**
        Returns true if this list contains an Object equal to obj; otherwise returns false.
        @return true if this list contains an Object equal to obj
     */
    public boolean contains(Object obj)
    {
        for (ListNode<E> node = head; node != null; node = node.getNext())
        {
            Object value = node.getValue();
            if (value.equals(obj))
            {
                return true;
            }
        }
        return false;
    }

    /**
        Returns the index of the first Object equal to obj; if not found,
        returns -1.

        @param obj  Object to find
        @return  the index of the first Object in equal to obj; if not found,
                  returns -1.
     */
    public int indexOf(Object obj)
    {
        int c = 0;
        for (ListNode<E> node = head; node != null; node = node.getNext())
        {
            Object value = node.getValue();
            if (value.equals(obj))
            {
                return c;
            }
            c++;
        }

        return -1;
    }

    /**
        Adds obj to this collection.  Returns true if successful;
        otherwise returns false.
        
        @param obj  element to add to this collection
        @return  true if successful; otherwise returns false.
     */
    public boolean add(E obj)
    {
        if (obj != null)
        {
            ListNode<E> node = new ListNode<E>(obj, null);
            
            if (head == null) 
            {
                head = node;
            }
            else
            {
                ListNode<E> n;

                for (n = head; n.getNext() != null; n = n.getNext());

                n.setNext(node);
            }
            
            nodeCount++;
            return true;
        }
        return false;
    }

    /**
        Removes the first element that is equal to obj, if any.
        Returns true if successful; otherwise returns false.

        @param obj  element to remove
        @return  true if successful; otherwise returns false.
     */
    public boolean remove(E obj)
    {
        for (ListNode<E> node = head; node != null; node = node.getNext())
        {
            if (node.getValue().equals(obj))
            {
                node.setNext(node.getNext().getNext());
                nodeCount--;
                return true;
            }
        }
        return false;
    }

    /**
        Returns the i-th element.

        @param i  element to get from the list
        @return element at index i
        @throws IndexOutOfBoundsException 
     */
    public E get(int i)
    {
        if (i < 0 || i >= nodeCount)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            int c = 0;
            
            for (ListNode<E> node = head; node != null; node = node.getNext())
            {
                if (++c == i) {
                    return node.getNext().getValue();
                }
            }
        }
        
        return null;
    }

    /**
        Replaces the i-th element with obj and returns the old value.
        
        @param i index of element to replace
        @param obj replacement element of element at index i
        @return old value previously located at index i
        @throws IndexOutOfBoundsException 
     */
    public E set(int i, E obj)
    {
        if (i < 0 || i >= nodeCount)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            int c = 0;
            
            for (ListNode<E> node = head; node != null; node = node.getNext())
            {
                
                if (++c == i) {
                    E oldNode = node.getNext().getValue();
                    node.setValue(obj);
                    return oldNode;
                }
            }
        }
        return null;
    }

    /**
        Inserts obj to become the i-th element. Increments the size
        of the list by one.
        
        @param i  insertion point in list for obj
        @param obj element to insert into list
        @throws IndexOutOfBoundsException 
     */
    public void add(int i, E obj)
    {
        if (i == 0)
        {
            head = new ListNode<E>(obj, head); 
            nodeCount++;
            return;
        }
        
        if (i < 0 || i >= nodeCount)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            ListNode<E> node = head;
            ListNode<E> newNode = new ListNode<E>(obj, null);
                
            for (int c = 0; c < i; c++)
            {
                node = node.getNext();
            }
                
            newNode.setNext(node.getNext());
            node.setNext(newNode);
        }
            
            nodeCount++;
    }
    /**
        Removes the i-th element and returns its value.
        Decrements the size of the list by one.

        @param i index of element to remove
        @return element removed from this list
     */
    public E remove(int i)
    {
        ListNode<E> node = head;

        if (i < 0 || i >= nodeCount)
        {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0)
        {
            E returned = node.getValue();
            node.setNext(node.getNext());
            nodeCount--;
            return returned;
        }
        else
        {            
            for (int c = 0; c < i - 1; c++)
            {
                node = node.getNext();
            }
            
            E toReturn = node.getNext().getValue();
            node.setNext(node.getNext().getNext());
            
            nodeCount--;
            return toReturn;
        }
    }

    /**
        Returns a string representation of this list.
        @return  a string representation of this list.
     */
    public String toString()
    {
        String result = "";
        
        for (ListNode<E> node = head; node != null; node = node.getNext())
        {
            result += node.getValue();
        }
        return result;
    }

    /**
        Returns an iterator for this collection.
        @return  an iterator for this collection.
     */
    public Iterator<E> iterator()
    {
        return new SinglyLinkedListIterator<E>(head);
    }
}

