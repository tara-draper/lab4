
/**
 * TODO - your description here
 *
 * @author TODO YOUR NAME HERE
 */

public class MRUList<T> extends MyLinkedList<T> {

    public boolean contains(Object o) {
	// TODO - your code here
	return false;
    }

    public boolean add(T x) {
	super.add(0, x);
	return true;
    }

    public void add(int index, T x) {
	super.add(0, x);
    }

}
