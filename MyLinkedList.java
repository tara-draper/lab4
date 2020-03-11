
/**
 * Authors; Tara Draper and Charles McClain
 * We adhered to the honor code on this assignment
 */

import java.util.AbstractList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> extends AbstractList<T> {

    Node head;
    Node tail;
    int size;
    int modCountList = 0;
   
    public MyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		size = 0;
    }

    private Node getNth(int index) {
		Node node = head;
		for (int i = 0; i <= index; i++) {
		    node = node.next;
		}
		return node;
    }

    public boolean add(T data) {
		add(size, data);
		return true;
    }

    public void add(int index, T data) throws IndexOutOfBoundsException {
		if (index > size) {
		    throw new IndexOutOfBoundsException();
		} else {
		    Node left;
		    if (isEmpty() || index == 0) {
		    	left = head;
		    } else {
		    	left = getNth(index - 1);
		    }
		    Node right = left.next;
		    Node node_add = new Node(data);
		    left.next = node_add;
		    right.prev = node_add;
		    node_add.next = right;
		    node_add.prev = left;
		    size++;
		}
    }

    public T get(int i) {
		Node node = getNth(i);
		return node.data;
    }

    public T set(int i, T data) {
		Node node = getNth(i);
		T item = node.data;
		node.data = data;
		return item;
    }

    public T remove(int i) throws IndexOutOfBoundsException {
		if (i > size - 1) {
		    throw new IndexOutOfBoundsException();
		} else {
		    Node removed = getNth(i);
		    Node left = removed.prev;
		    Node right = removed.next;
		    T item = removed.data;
		    left.next = right;
		    right.prev = left;
		    size--;
		    return item;
		}
    }

    public void clear() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		size = 0;
    }

    public boolean isEmpty() {
		if (size == 0) {
		    return true;
		} else {
		    return false;
		}
    }

    public int size() {
    	return size;
    }


    // ListIterator class
    protected class MyListIterator implements ListIterator<T> {
    	Node left = head;
    	int index = 0;
    	
		public boolean hasPrevious() {
			if(left == head) {
				return false;
			}else {
				return true;
			}
		}
			
		public T previous() throws NoSuchElementException { 
			if(left==head) {
				throw new NoSuchElementException();
			}else {
				T item = left.data;
				left = left.prev;
				index--;
				modCountList++;
				return item;
			}
		}
		
		public boolean hasNext() {
		    if (left.next != null) {
		    	return true;
		    } else {
		    	return false;
		    }
		}
	
		public T next() throws NoSuchElementException {
		    if (left.next == tail) {
		    	throw new NoSuchElementException();
		    } else {
		    	left = left.next;
		    	index++;
		    	modCountList++;
		    	return left.data;
		    }
	
		}

		public int nextIndex() {
		    if (index == size) {
		    	return size;
		    } else {
		    	return index + 1;
		    }
	
		}
	
		public int previousIndex() {
		    if (left == head) {
		    	return -1;
		    } else {
		    	return index;
		    }
	
		}
	
		public void set(T x) {
			if() {
				throw new IllegalStateException();
			}else {
				left.data = x;
			}
		}
	
		// Change the value in the node returned by the most recent next/previous with
		// the new value.
		// Throw an IllegalStateException if neither next nor previous were called
		// Throw an IllegalStateException if add or remove have been called since the
		// most recent next/previous
		public void remove() throws IllegalStateException{
			if() {
				throw new IllegalStateException();
			}else {
				Node right = this.left.next;
				Node left = this.left.prev;
				left.next = right;
				right.prev = left;
				this.left = left;
			}
		}
	
		// Remove the last element returned by the most recent call to either
		// next/previous
		// Throw an IllegalStateException if neither next nor previous were called
		// Throw an IllegalStateException if add has been called since the most recent
		// next/previous
		
		public void add(T x) {
			Node node = new Node(x);
			Node right = left.next;
			left.next = node;
			right.prev = node;
			node.next = right;
			node.prev = left;
			left = left.next;
			index++;
			modCountList++;
		}
		// Insert the given item into the list immediately before whatever would have
		// been returned by a call to next()
		// The new item is inserted before the current cursor, so it would be returned
		// by a call to previous() immediately following.
		// The value of nextIndex or previousIndex both are increased by one
	
	}
    //End ListIterator class
    
    // Node class
    protected class Node {
		T data;
		Node next;
		Node prev;

		protected Node(T item) {
		    data = item;
		    next = null;
		    prev = null;
		}

		protected Node() {
		    this(null);
		}
    }
    //End Node class
}
