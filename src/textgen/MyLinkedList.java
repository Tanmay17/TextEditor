package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode();
                tail = new LLNode();
                head.next = tail;
                head.prev = null;
                tail.next = null;
                tail.prev = head;
        }

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if(element == null){
                    throw new NullPointerException();
                }
                LLNode<E> list = new LLNode(element,tail.prev,tail);
                tail.prev.next = list;
                tail.prev = list;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
                if(index < 0 ){
                    throw new IndexOutOfBoundsException();
                    }
                    LLNode<E> node = traverseToNode(index);
                    return node.data;
	}

        protected LLNode<E> traverseToNode(int index){
            LLNode<E> node = head;
            for(int i = 0;i <= index;i++){
                node = node.next;
                if(node.data == null){
                    throw new IndexOutOfBoundsException();
                }
            }
            return node;
        }
	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
            if(element==null)
			throw new NullPointerException();
		if(index<0){
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> pointer=traverseToNode(index-1);
		LLNode<E> node=new LLNode(element,pointer,pointer.next);
		pointer.next.prev=node;
		pointer.next=node;
	}


	/** Return the size of the list */
	public int size() 
	{
		LLNode<E> pointer=head;
		int size=0;
		while((pointer=pointer.next)!=null){
			size++;
		}
		return size-1;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if(index<0){
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> pointer=traverseToNode(index);
		pointer.prev.next=pointer.next;
		pointer.next.prev=pointer.prev;
		pointer.next=null;
		pointer.prev=null;
		
		return pointer.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if(element==null)
			throw new NullPointerException();
		if(index<0){
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> pointer=traverseToNode(index);
		E data=pointer.data;
		pointer.data=element;
		// TODO: Implement this method
		return data;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E data,LLNode<E> prev,LLNode<E> next){
		this.data = data;
		this.prev = prev;
		this.next = next;
		
	}
	public LLNode(){
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
}
