
/**
 * Authors; Tara Draper and Charles McClain
 * We adhered to the honor code on this assignment
 */
//
//
import java.util.AbstractList;
import java.util.ListIterator;

public class MyLinkedList<T> extends AbstractList<T> {

    Node head;
    Node tail;
    int size;

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

    protected class MyListIterator implements ListIterator<T> {

		boolean hasNext() {// Tara
	
		}
	
		// Return true if there are more elements when going in the forward direction.
		T next() {// Tara
	
		}
	
		// Return the next element in the list when going forward.
		// Throw NoSuchElementException if there is no such element
		boolean hasPrevious() {// charles
			
		}
	
		// Return true if there are more elements when going in the reverse direction.
		T previous() {// charles
			
		}
	
		// Return the next element in the list when going backwards.
		// Throw NoSuchElementException if there is no such element
		int nextIndex() {// Tara
	
		}
	
		// Return the index of the element that would be returned by a call to next()
		// Return the list size if at the end of the list
		int previousIndex() {// tara
	
		}
	
		// Return the index of the element that would be returned by a call to
		// previous()
		// Return -1 if at the start of the list
		void set(T x) {// charles
	
		}
	
		// Change the value in the node returned by the most recent next/previous with
		// the new value.
		// Throw an IllegalStateException if neither next nor previous were called
		// Throw an IllegalStateException if add or remove have been called since the
		// most recent next/previous
		void remove() {// tara
	
		}
	
		// Remove the last element returned by the most recent call to either
		// next/previous
		// Throw an IllegalStateException if neither next nor previous were called
		// Throw an IllegalStateException if add has been called since the most recent
		// next/previous
		void add(T x) {// charles
	
		}
		// Insert the given item into the list immediately before whatever would have
		// been returned by a call to next()
		// The new item is inserted before the current cursor, so it would be returned
		// by a call to previous() immediately following.
		// The value of nextIndex or previousIndex both are increased by one

    }

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

}
