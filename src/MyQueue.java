/**
 * MyQueue is a custom implementation of a Queue data structure.
 * The queue is implemented using MyLinkedList as the underlying storage.
 *
 * @param <T> the type of elements in the queue, which must implement Comparable
 */
public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list; 

    
    /**
     * Constructor to initialize an empty queue.
     */
    public MyQueue() {
        list = new MyLinkedList<>();
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the size of the queue
     */
    public int size() {
        return list.size();
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean empty() {
        return list.size() == 0;
    }

    /**
     * Retrieves the front element of the queue without removing it.
     *
     * @return the front element of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public T peek() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(0);
    }

    /**
     * Adds a new element to the end of the queue.
     *
     * @param item the element to add
     * @return the added element
     */
    public T enqueue(T item) {
        list.addLast(item); 
        return item;
    }

    /**
     * Removes and returns the front element of the queue.
     *
     * @return the front element of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public T dequeue() {
        T removingItem = peek();t
        list.removeFirst();
        return removingItem;
    }
}
