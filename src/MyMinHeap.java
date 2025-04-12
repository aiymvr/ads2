/**
 * MyMinHeap is a custom implementation of a Min-Heap data structure.
 * The heap is implemented using MyArrayList as the underlying storage.
 *
 * @param <T> the type of elements in the heap, which must implement Comparable
 */
public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list; 

    /**
     * Constructor to initialize an empty Min-Heap.
     */
    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    /**
     * Returns the number of elements in the heap.
     *
     * @return the size of the heap
     */
    public int size() {
        return list.size();
    }

    /**
     * Checks if the heap is empty.
     *
     * @return true if the heap is empty, false otherwise
     */
    public boolean empty() {
        return list.size() == 0;
    }

    /**
     * Retrieves the minimum element (root) of the heap without removing it.
     *
     * @return the minimum element in the heap
     * @throws IllegalStateException if the heap is empty
     */
    public T getMin() {
        if (empty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return list.get(0);
    }

    /**
     * Inserts a new element into the heap and restores the heap property.
     *
     * @param item the element to insert
     */
    public void insert(T item) {
        list.add(item); // Add the new element to the end of the list
        traverseUp(list.size() - 1); // Restore the heap property by moving the element up
    }

    /**
     * Removes and returns the minimum element (root) of the heap.
     *
     * @return the minimum element in the heap
     * @throws IllegalStateException if the heap is empty
     */
    public T extractMin() {
        if (empty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = list.get(0); // Get the root element
        list.set(0, list.get(list.size() - 1)); // Replace the root with the last element
        list.remove(list.size() - 1); // Remove the last element
        heapify(0); // Restore the heap property by moving the root element down
        return min;
    }

    /**
     * Swaps two elements in the heap by their indices.
     *
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * Restores the heap property by moving an element up the heap.
     *
     * @param index the index of the element to move up
     */
    private void traverseUp(int index) {
        while (index > 0) {
            int parentIndex = parentOf(index);
            if (list.get(index).compareTo(list.get(parentIndex)) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    /**
     * Returns the index of the parent of the given element.
     *
     * @param index the index of the element
     * @return the index of the parent
     */
    private int parentOf(int index)
