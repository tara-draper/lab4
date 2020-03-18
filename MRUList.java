import java.util.ListIterator;

/**
 * TODO - your description here
 *
 * @author TODO YOUR NAME HERE
 */

public class MRUList<T> extends MyLinkedList<T> {

    public boolean contains(Object o) {
    	@SuppressWarnings("unchecked")
		T target = (T) o;
    	ListIterator<T> iterator = listIterator();
    	while(iterator.hasNext()) {
    		T item = iterator.next();
    		if(item==target) {
    			iterator.remove();
    			add(item);
    			return true;
    		}
    	}
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
