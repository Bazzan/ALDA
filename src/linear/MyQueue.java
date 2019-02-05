package linear;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MyQueue<E> implements ALDAQueue{
    
	private class Node{
		E element;
		Node next;
	}

	private Node front, rear;
	private List<E> queue;
	private int size = 0;
	private int capacity;
	public MyQueue(int capacity) { init(); }

	

	
	public void init() {
		System.out.println("init");

		front = rear = null;
	}
	
	
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(Object element) {
		if(element != null) {
		    Node oldRear = rear;
		    rear = new Node();
		    rear.element = (E) element;
		    rear.next = null;
		    if (isEmpty()) 
		    {
		      front = rear;
		    }
		    else 
		    {
		      oldRear.next = rear;
		    }
		    size++;
			
		}
		
		System.out.println(element + " skapades");
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAll(Collection c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object remove() {
	    E element = front.element;
	    front = front.next;
	    if (isEmpty()) 
	    {
	      rear = null;
	    }
	    size--;
	    return element;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean isEmpty() {
		
		return (size == 0);
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return (size == 100);
	}

	@Override
	public int totalCapacity() {
		
		return capacity;
	}

	@Override
	public int currentCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int discriminate(Object e) {
		// TODO Auto-generated method stub
		return 0;
	}

}
