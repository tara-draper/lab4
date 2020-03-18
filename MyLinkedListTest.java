import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ListIterator;
import java.util.NoSuchElementException;

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
    
    //Iterator tests
    
    @Test
    public void testMovement() {
    	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
		    list.add(i);
		}
		ListIterator<Integer> myIterator = list.QQQlistIterator();
		assertTrue(myIterator.hasNext());
		assertEquals("first index is zero", 0, myIterator.nextIndex());
		assertTrue(!myIterator.hasPrevious());
		assertEquals("if at the beginning of the list, the previous index is -1", -1, myIterator.previousIndex());
		int num = myIterator.next();
		assertEquals("check to see if next returns the correct number", 0, num);
		assertTrue(myIterator.hasNext());
		assertEquals("check next index after moving", 1, myIterator.nextIndex());
		assertEquals("check previous index after moving", 0, myIterator.previousIndex());
		assertTrue(myIterator.hasPrevious());
		num = myIterator.previous();
		assertEquals("check to see if prev returns the correct number", 0, num);
		assertTrue(!myIterator.hasPrevious());
    }
    
    @Test(expected=NoSuchElementException.class)
    public void testIteratorInvalidNext() {
    	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		ListIterator<Integer> myIterator = list.QQQlistIterator();
		myIterator.next();
    }
    
    @Test(expected=NoSuchElementException.class)
    public void testIteratorInvalidPrevious() {
    	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		ListIterator<Integer> myIterator = list.QQQlistIterator();
		myIterator.previous();
    }
    
    @Test(expected=IllegalStateException.class)
    public void testIteratorRemoveHasntMoved() {
    	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
		    list.add(i);
		}
		ListIterator<Integer> myIterator = list.QQQlistIterator();
		myIterator.remove();
    }
    
    @Test(expected=IllegalStateException.class)
    public void testIteratorSetHasntMoved() {
    	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
		    list.add(i);
		}
		ListIterator<Integer> myIterator = list.QQQlistIterator();
		myIterator.set(20);
    }
    
    @Test(expected=IllegalStateException.class)
    public void testIteratorIllegalSet() {
    	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
		    list.add(i);
		}
		ListIterator<Integer> iterator1 = list.QQQlistIterator();
		iterator1.next();
		iterator1.next();
		ListIterator<Integer> iterator2 = list.QQQlistIterator();
		iterator2.next();
		iterator2.remove();
		iterator1.set(100);
    }
    
    @Test(expected=IllegalStateException.class)
    public void testIteratorIllegalRemove() {
    	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
		    list.add(i);
		}
		ListIterator<Integer> iterator1 = list.QQQlistIterator();
		iterator1.next();
		iterator1.next();
		ListIterator<Integer> iterator2 = list.QQQlistIterator();
		iterator2.add(50);
		iterator1.remove();

    }
    
    @Test
    public void testIteratorAdd() {
    	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
		    list.add(i);
		}
		assertEquals("list is size 10", 10, list.size());
		ListIterator<Integer> myIterator = list.QQQlistIterator();
		myIterator.add(50);
		assertEquals("list size is 11", 11, list.size());
		assertEquals("moved the cursor", 1, myIterator.nextIndex());
		assertEquals("moved the cursor", 0, myIterator.previousIndex());
		assertTrue(myIterator.hasPrevious());
		int num = myIterator.previous();
		assertEquals("returns the correct number", 50, num);
    }
    
    @Test
    public void testIteratorRemove() {
    	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
		    list.add(i);
		}
		assertEquals("list is size 10", 10, list.size());
		ListIterator<Integer> myIterator = list.QQQlistIterator();
		myIterator.next();
		myIterator.next();
		myIterator.remove();
		assertEquals("list size is 9", 9, list.size());
		assertEquals("next index changes to remain in order", 1, myIterator.nextIndex());
		assertEquals("previous index changes to reamin in order", 0, myIterator.previousIndex());
		myIterator.next();
		myIterator.next();
		myIterator.previous();
		myIterator.remove();
		assertEquals("list size is 8", 8, list.size());
		assertEquals("next index doesnt change when moving backwards", 2, myIterator.nextIndex());
		assertEquals("previous index doesnt change when moving backwards", 1, myIterator.previousIndex());
    }
    
    @Test
    public void testIteratorSet() {
    	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
		    list.add(i);
		}
		ListIterator<Integer> myIterator = list.QQQlistIterator();
		myIterator.next();
		myIterator.set(50);
		int num = myIterator.previous();
		assertEquals("set should change the last acessed item", 50, num);
		myIterator.set(10);
		num = myIterator.next();
		assertEquals("set should change the last acessed item", 10, num);
		assertEquals("size is unchanged", 10, list.size);
    }
}
