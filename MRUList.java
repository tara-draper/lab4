/**
 * TODO - your description here
 *
 * @author TODO YOUR NAME HERE
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
        // TODO - your code here
    	return false;
    }

    public void add(int index, T x) {
        // TODO - your code here
    }
    
}
