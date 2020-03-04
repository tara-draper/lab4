
/**
 * Authors; Tara Draper and Charles McClain
 * We adhered to the honor code on this assignment
 */
//
//
import java.util.AbstractList;

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

    // protected class MyListIterator implements ListIterator<T> {

    // TODO - your code here

    // }

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
