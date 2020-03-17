import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MyLinkedListTest {

    @Test
    public void testIsEmpty() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
		    list.add(i);
		}
		assertEquals("Size is 10", 10, list.size());
		list.clear();
		assertEquals("Size is zero", 0, list.size());
		assertTrue(list.isEmpty());
    }

    @Test
    public void testAddIntT() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
		    list.add(i);
		}
		list.add(4, 50);
		int item = list.get(4);
		assertEquals("the item at index 4 should be 50", 50, item);
    }

    @Test
    public void testSetIntT() {
    	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
    	for (int i = 0; i < 10; i++) {
    		list.add(i);
    	}
    	int returned = list.set(4, 50);
    	assertEquals("the item returned should be 4", 4, returned);

    	int item = list.get(4);
    	assertEquals("the item at index 4 should be 50", 50, item);
    }

    @Test
    public void testRemoveIntEnd() {
    	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
		    list.add(i);
		}
		int returned = list.remove(list.size() - 1);
		assertEquals("the item returned should be 9", 9, returned);
		assertEquals("Size is 9", 9, list.size());
    }

    @Test
    public void testRemoveIntMiddle() {
    	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
		    list.add(i);
		}
		int returned = list.remove(4);
		assertEquals("the item returned should be 4", 4, returned);
		assertEquals("Size is 9", 9, list.size());
    }

}
