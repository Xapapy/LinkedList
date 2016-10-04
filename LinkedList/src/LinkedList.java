////////////////////////////////
//////////////////////////////// private Boolean add(Object o);
//////////////////////////////// private void add(int loc, Object o);
// private Object remove(int loc);
// private boolean remove(Object o);
// private Object set(int loc, Object o);
// private Object get(int loc);
//////////////////////////////// private int size;
// private int indexOf(Object o);
// private void clear();
// private boolean contains(Object o);
// private int lastIndexOf(Object o);
// private Object[] toArray();
// private String toString();
// private boolean equals(Object o);
// boolean isObjectmpty()
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
    }
    
    /**
     * Adds a node to the end of the list;
     * @param data - 
     * @return
     */
    public boolean add( E data )
    {
        if (head == null)
        {
            head = new Node( data, null );
            return true;
        }
        else
        {
            Node temp = head;
            while ( temp.next != null ) 
            {
                temp = temp.next;
            }
            temp.next = new Node( data, null );
            ++size;
            return true;
        }
    }
    
    /**
     * Returns the size of the LinkedList.
     * @return the size of the LinkedList.
     */
    public int size()
    {
        return size();
    }
    
    /**
     * Adds an object to the LinkedList at a defined location.
     * @param loc - The location you want to add the object to.
     * @param o - The object you want to add.
     */
    public void add( int loc, E o )
    {
        Node temp = head;
        if ( loc > size || loc < 0 )
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            int i = 0;
            while ( i < loc )
            {
                temp = temp.next;
                ++i;
            }
            temp.next = new Node( o, temp.next );
            ++size;
        }
    }
    
    /**
     * Returns the data of the LinkedList in a String form.
     */
    public String toString()
    {
        if ( size <= 0 )
        {
            return "[]";
        }
        else {
            StringBuilder finalString = new StringBuilder("[");
            Node temp = head;
            while ( temp.next.next != null )
            {
                finalString.append( temp.data.toString() + ", " );
                temp = temp.next;
            }
            finalString.append( temp.next.data.toString() + "]" );
            return finalString.toString();
            
        }
    }
    
    public E get( int loc )
    {
        Node temp = head;
        if ( loc > size || loc < 0 )
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            int i = 0;
            while ( i <= loc )
            {
                temp = temp.next;
                ++i;
            }
        }
        return ( E ) temp.data;
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
            new Node( null, null );
        }
        
        /**
         * Builds a new Node.
         * @param data - The data the node will hold. Must be type E.
         * @param next - The next node in the list.
         */
        public Node( E data, Node next )
        {
            super();
            this.data = data;
            this.next = next;
        }
        
        /**
         * Returns the next in the list in relation to the current node.
         * @return The next node in the list.
         */
        public Node getNext()
        {
            return this.next;
        }
        
        /**
         * Returns the data in the node.
         * @return the node's data.
         */
        public E getData()
        {
            return this.data;
        }
    }
}
