package linear;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class MyQueue<E> implements ALDAQueue<E> {

	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element) {
			this.element = element;
//			this.next = null;

		}
	}

	private Node<E> front, rear;
	private int capacity;
	private int totalCapacity;

	public MyQueue(int capacity) {
		System.out.println("init");
		if (capacity < 1) {
			throw new IllegalArgumentException("It can be lesser than 1 :(");
		} else {
			this.capacity = capacity;
			this.totalCapacity = capacity;
		}

		front = rear = null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void  add(E element) {
		if(element == null) {
			throw new NullPointerException();
		}else if(size() >= totalCapacity()) {
			throw new IllegalStateException();
		}else {
			
			// If queue is empty, then new node is front and rear both
			if (front == null) {
				front = new Node<E>(element);
				rear = front;
				capacity--;
				System.out.println(element + " created");

			}else if (front != null){	// Add the new node at the end of queue and change rear
				this.rear.next = new Node<E>(element);
				this.rear = rear.next;
				capacity--;
			}
			System.out.println(element + " created");
		}
	}
	
	@Override
	public void addAll(Collection<? extends E>  c) {
		for (E e : c) {
			this.add(e);
		}


	}


	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	
	private class MyIterator implements Iterator<E> {
		private Node<E> node = null;

		@Override
		public boolean hasNext() {
			return node != rear;

		}

		@Override
		public E next() {
			if(front == null) {
				throw new NoSuchElementException();
			}else if(node == null) {
				node = front;
				return node.element;
			}
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			node =  node.next;
			return node.element;
		}
		
		
		
	}
	
	
	@Override
	public int discriminate(E e) {
		if(e == null) {
			throw new NullPointerException();
		}else {
			int nodeMatches = 0;
			MyQueue<E> queue1 = new MyQueue(totalCapacity);
			MyQueue<E> queue2 = new MyQueue(totalCapacity);
			MyIterator iter = new MyIterator();
			
			while(iter.hasNext()) {
				if(iter.next().equals(e)) {
					nodeMatches++;
					front = front.next;
					capacity++;
					queue1.add(iter.node.element);
				}else {
					front = front.next;
					capacity++;
					queue2.add(iter.node.element);
				}
			}
			
			for(E ele : queue2) {
				this.add(ele);
			}
			for(E ele : queue1) {
				this.add(ele);
			}
			return nodeMatches;
			
		}
		
	}




	@Override
	public E remove() {
		
		
		if(front != rear) {
			
			Node<E> node = this.front;
			this.front = this.front.next;
			capacity++;
		
			return node.element;
		
		}else if(front == rear && front != null) {
			Node<E> node = this.front;
			front = rear = null;
			capacity++; 
			return node.element;
			
		}else
			
		throw new NoSuchElementException();
		
	}

	@Override
	public E peek() {
		if(front != null) {
			return front.element;
		}else
		return null;
	}

	@Override
	public void clear() {
		front = rear = null;
		
		capacity = totalCapacity;
	}

	@Override
	public int size() {
		int size = 0;
		for(Node<E> node = front; node != null; node = node.next ) {
			size++;
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(front == null) {
//			if(rear == null) {
			return true; //(capacity == 0);	
//			}
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(this.size() == totalCapacity()) {
			return true;
		}else {
			return false;
		}
			
	}

	@Override
	public int totalCapacity() {

		return totalCapacity;
	}

	@Override
	public int currentCapacity() {
		// TODO Auto-generated method stub
		return capacity;
	}



	public String toString() {
		if (size() == 0)
			return "[]";
		String str = "[";
		for (Node<E> node = front; node != null; node = node.next) {
			str += node.element;
			if (node != rear)
				str += ", ";
		}
		str += "]";
		return str;
	}



}
