package utils;
import java.util.ArrayList;
import java.lang.StringBuilder;


public class MinPriorityQueue<T extends Comparable<T>> {

    /**
     * Creates an empty queue.
     */
    private int array_size;
    private int stack_pointer;
    private ArrayList<T> array;
    
    public MinPriorityQueue() {
        // TODO implement the constructor
        this.array = new ArrayList<T>(10);
        array.add(0, null);
        array_size = 10;
        stack_pointer = 1;
    }

    /**
     * Returns the number of elements currently in the queue.
     */
    public int size() {
        // TODO implement this method
        return array_size;
    }

    /**
     * Adds elem to the queue.
     */
    public void add(T elem) {
        // TODO implement this method
    	if(stack_pointer >= array_size) {
    		array.ensureCapacity(array_size*2);
    		array_size = array_size*2;
    	}
    	if(stack_pointer < array_size) {
    		array.add(elem);
    		stack_pointer++;
    	}
    	
    	int i = stack_pointer-1;
    	while(i > 1 && array.get(i/2).compareTo(array.get(i)) > 0) {
    		swap(i/2, i);
    		i = i/2;
    	}
    }

    /**
     * Removes, and returns, the element at the front of the queue.
     */
    public T remove() {
        // TODO implement this method
    	if (stack_pointer < 1 ) {
    		System.out.println("Cannot remove from empty queue");
    		return null;
    	}
        T min = array.get(1);
        array.set(1, array.get(stack_pointer-1));
        stack_pointer -= 1;
        
        if(array_size/stack_pointer == 4) {
        	//reduce size
        }
        min_heapify(1);
        return min;
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        // TODO implement this method
    	for (int i = 0; i < array.size(); i++ ) {
    		if(array.get(i) != null) {
    			return false;
    		}
    	}
        return true;
    }
    
    public void print() {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < stack_pointer; i++ ) {
    		if(array.get(i) != null) {
    			sb.append(array.get(i).toString());
    			sb.append(" ");
    		}
    	}
    	System.out.println(sb.toString());
    }
    
    public T minimum() {
    	if (this.array.get(1) != null){
    		T min = this.array.get(1);
    		return min;
    	}
    	return null;
    }
    
    public void min_heapify(int position) {
    	int left = 2* position;
    	int right = left + 1;
    	int temp = position;
    	
    	if (left < stack_pointer && array.get(left).compareTo(array.get(temp)) < 0) {
    		temp = left;
    	}
    	
    	if (right < stack_pointer && array.get(right).compareTo(array.get(temp)) < 0) {
    		temp = right;
    	}
    	if (temp == position) {
    		return;
    	}
    	
    	swap(position, temp);
    	min_heapify(temp);
    	
    }
    
    public void swap(int a, int b) {
    	T temp = array.get(a);
    	array.set(a, array.get(b));
    	array.set(b, temp);
    }
}
