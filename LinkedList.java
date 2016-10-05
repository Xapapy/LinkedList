////////////////////////////////
//////////////////////////////// private Boolean add(Object o);
//////////////////////////////// private void add(int loc, Object o);
// private Object remove(int loc);
////////////////////////////////private boolean remove(Object o);
// private Object set(int loc, Object o);
//////////////////////////////// private Object get(int loc);
//////////////////////////////// private int size;
//////////////////////////////// private int indexOf(Object o);
//////////////////////////////// private void clear();
//////////////////////////////// private boolean contains(Object o);
// private int lastIndexOf(Object o);
// private Object[] toArray();
//////////////////////////////// private String toString();
// private boolean equals(Object o);
//////////////////////////////// boolean isObjectEmpty()
/**
 * @version 9/28/16
 * @author bushneca18
 * @param <E> - The object type the list will hold.            
 */
public class LinkedList<E>
{

    private Node<E> head;
    private int size;

    /**
     * Default constructor. Creates an empty LinkedList with a head of "null".
     */
    public LinkedList()
    {
        super();
        head = null;
        size = 0;
    }

    private void locationCheck(int loc)
    {
        if (loc > size || loc < 0 || (size == 0 && loc == 0))
        {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Adds a node to the end of the list;
     * 
     * @param data
     *            -
     * @return
     */
    public boolean add(E data)
    {
        if (head == null)
        {
            head = new Node(data, null);
            ++size;
            return true;
        } 
        else
        {
            Node temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = new Node(data, null);
            ++size;
            return true;
        }
    }

    /**
     * Returns the size of the LinkedList.
     * 
     * @return the size of the LinkedList.
     */
    public int size()
    {
        return size;
    }

    /**
     * Adds an object to the LinkedList at a defined location.
     * 
     * @param loc
     *            - The location you want to add the object to.
     * @param o
     *            - The object you want to add.
     */
    public void add(int loc, E o)
    {
        this.locationCheck( loc );
        if (head == null && loc == 0)
        {
            head = new Node( o, null );
        }
        else
        {
            Node temp = head;
            int i = 0;
            while (i < loc)
            {
                temp = temp.next;
                ++i;
            }
            temp.next = new Node(o, temp.next);
            ++size;
        }
    }
    
    /**
     * Removes the first instance of a given Object from the LinkedList
     * @param o - the Object to be removed
     * @return true of the Object was present, false if it wasn't
     */
    public boolean remove( E o )
    {
        int location = this.indexOf( o );
        if ( location > -1 )
        {
            if ( location == 0 ) //May be an issue if object occupies head 
            {
                head = null;
                --size;
                return true;
            }
            Node temp = head;
            for ( int i = 0; i > location; ++i )
            {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            --size;
            return true;
        }
        return false;
    }
    
    /**
     * Returns the data of the LinkedList in a String form.
     * @return Returns the LinkedList's data in the form of a String.
     */
    public String toString()
    {
        if ( size <= 0 )
        {
            return "[]";
        }
        else
        {
            String finalString = "[";
            Node temp = head;
            while ( temp.next != null )
            {
                finalString += temp.data.toString() + ", ";
                temp = temp.next;
            }
            finalString += temp.data.toString() + "]";
            return finalString;

        }
    }

    /**
     * Returns the Object at a given location
     * @param loc - the index of the Object that will be returned
     * @return returns the object at the given index
     */
    public E get( int loc )
    {
        this.locationCheck( loc );
        if ( loc == size )
        {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = head;
        int i = 0;
        while ( i < loc )
        {
            temp = temp.next;
            ++i;
        }
        return (E) temp.data;
    }
    
    /**
     * Returns the index of a given Object in the LinkedList
     * @param o - The object to be searched for
     * @return If <= -1, not present, otherwise returns the index of o
     */
    public int indexOf( E o )
    {
        if ( head != null )
        {
            Node temp = head;
            int loc = -1;
            int i = 0;
            while ( temp != null )
            {
                if ( temp.data.equals( o ) )
                {
                    loc = i;
                    return loc;
                }
                temp = temp.next;
                ++i;
            }
            return loc;
        }
        return -1;
    }
    
    /**
     * Clears the LinkedList of all data.
     */
    public void clear()
    {
        head = null;
        size = 0;
    }
    
    /**
     * Determines of the LinkedList contains a given Object
     * @param o - the Object to be searched for
     * @return returns true if it contains the object, false if it does not
     */
    public boolean contains( E o )
    {
        int loc = indexOf( o );
        if ( loc > -1 )
        {
            return true;
        }
        return false;
    }
    
    /**
     * Determines if the LinkedList contains no data
     * @return Returns true if size > 0, and false otherwise
     */
    public boolean isEmpty()
    {
        if ( size > 0 )
        {
            return true;
        }
        return false;
    }
    

    /**
     * @author bushneca18
     * @param <E> - The data type the ListNode will hold.         
     */
    private class Node<E>
    {
        private E data;
        private Node<E> next;

        /**
         * Default constructor. Builds an empty node with a next of "null".
         */
        public Node()
        {
            super();
            new Node(null, null);
        }

        /**
         * Builds a new Node.
         * 
         * @param data
         *            - The data the node will hold. Must be type E.
         * @param next
         *            - The next node in the list.
         */
        public Node(E data, Node next)
        {
            super();
            this.data = data;
            this.next = next;
        }

        /**
         * Returns the next in the list in relation to the current node.
         * 
         * @return The next node in the list.
         */
        public Node getNext()
        {
            return this.next;
        }

        /**
         * Returns the data in the node.
         * 
         * @return the node's data.
         */
        public E getData()
        {
            return this.data;
        }
    }
}
