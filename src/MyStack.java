/**
 * MyStack is a custom implementation of a Stack data structure.
 * The stack is implemented using MyArrayList as the underlying storage.
 *
 * @param <T> the type of elements in the stack
 */
public class MyStack<T> {
    private MyArrayList<T> list; 
    /**
     * Constructor to initialize an empty stack.
     */
    public MyStack() {
        list = new MyArrayList<>();
    }

    /**
     * Adds a new element to the top of the stack.
     *
     * @param newItem the element to add
     * @return the added element
     */
    public T push(T newItem) {
        list.add(newItem); 
        return newItem;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean empty() {
        return list.size() == 0;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the size of the stack
     */
    public int size() {
        return list.size();
    }

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the top element of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public T pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T top = list.get(list.size() - 1); 
        list.remove(list.size() - 1); 
        return top;
    }

    /**
     * Retrieves the top element of the stack without removing it.
     *
     * @return the top element of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public T peek() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(list.size() - 1); 
    }
}
