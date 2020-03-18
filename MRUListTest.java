import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MRUListTest {

    @Test
    public void testAddT() {
	MRUList<Integer> list = new MRUList<Integer>();
	for (int i = 0; i < 10; i++) {
	    list.add(i);
	}
	int value = list.get(0);
	assertEquals("first item should be 9", 9, value);
    }

    @Test
    public void testAddIntT() {
	MRUList<Integer> list = new MRUList<Integer>();
	for (int i = 0; i < 10; i++) {
	    list.add(5, i);
	}
	int value = list.get(0);
	assertEquals("first item should be 9", 9, value);
    }

    @Test
    public void testContainsObject() {
	MRUList<Integer> list = new MRUList<Integer>();
	for (int i = 0; i < 10; i++) {
	    list.add(i);
	}
	assertTrue(list.contains(5));
	int value = list.get(0);
	assertEquals("first item should be 9", 5, value);
    }

    @Test
    public void testNotContainsObject() {
	MRUList<Integer> list = new MRUList<Integer>();
	for (int i = 0; i < 10; i++) {
	    list.add(i);
	}
	assertFalse(list.contains(15));
	int value = list.get(0);
	assertEquals("first item should be 9", 9, value);
    }

}
