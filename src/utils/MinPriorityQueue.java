package utils;

public class MinPriorityQueue<T extends Comparable<T>> {

    /**
     * Creates an empty queue.
     */
    private int array_size;

    public MinPriorityQueue() {
        // TODO implement the constructor
        l = new List();
    }

    /**
     * Returns the number of elements currently in the queue.
     */
    public int size() {
        // TODO implement this method
        int size = l.size();
        return size;
    }

    /**
     * Adds elem to the queue.
     */
    public void add(T elem) {
        // TODO implement this method
    }

    /**
     * Removes, and returns, the element at the front of the queue.
     */
    public T remove() {
        // TODO implement this method
        return null;
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        // TODO implement this method
        if (l.size() == 0){
          return false;
        }
        return true;
    }

}
