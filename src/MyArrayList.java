/**
 * MyArrayList is a custom implementation of an ArrayList.
 * It supports a better API for working with array such as: insertion, deletion, altering, searching
 * @param <T> the type of elements in this list
 */

import java.util.Iterator;
public class MyArrayList<T> implements MyList<T> {
    private Object[] array; //Array to store elements
    private int size = 0; //Number of elements in the list
    private int capacity = 5; //Capacity of the list

    /**
     * Constructor to initialize the list with default capacity.
     */
    public MyArrayList() {
        array = new Object[capacity];
    }

    /**
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    /**
     * Adds a new item to the end of the list.
     *
     * @param newItem is the item to be added
     */
    @Override
    public void add(T newItem) {
        if (size == capacity) {
            increaseBuffer();
        }
        array[size++] = newItem;
    }

    /**
     * The size() method indicates how many elements are in the list.
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Sets the element at the specified index to a new value.
     *
     * @param index the index of the element to set
     * @param item  the new value to set
     */
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        array[index] = item;
    }

    /**
     * Adds a new item at the specified index.
     *
     * @param index the index where the item should be added
     * @param item  the item to add
     */
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("error");
        }
        if (size == capacity) {
            increaseBuffer();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;

    }

    /**
     * Adds a new item to the beginning of the list.
     *
     * @param item the item to add
     */

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    /**
     * Adds a new item to the end of the list.
     *
     * @param item the item to add
     */
    @Override
    public void addLast(T item) {
        add(item);
    }

    /**
     * Retrieves the first element in the list.
     *
     * @return the first element in the list
     */
    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("empty");
        }
        return get(0);
    }

    /**
     * Retrieves the last element in the list.
     *
     * @return the last element in the list
     */
    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("empty");
        }
        return get(size - 1);
    }

    /**
     * Removes the element at the specified index.
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
    }


    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    /**
     * Sorts the elements in the list in ascending order.
     */
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) array[j]).compareTo((T) array[j + 1]) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Returns the index of the first occurrence of the specified element.
     *
     * @param object the element to search for
     * @return the index of the first occurrence, or -1 if not found
     */
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element.
     *
     * @param object the element to search for
     * @return the index of the last occurrence, or -1 if not found
     */
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks if the specified element exists in the list.
     *
     * @param object the element to check
     * @return true if the element exists, false otherwise
     */
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    /**
     * Converts the list to an array.
     *
     * @return an array containing all elements in the list
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }

    /**
     * Clears all elements from the list.
     */
    @Override
    public void clear() {
        array = new Object[capacity];
        size = 0;
    }

    /**
     * @return an iterator for the list
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

    /**
     * Increases the internal buffer size by 1.5 times.
     */
    private void increaseBuffer() {
        capacity = (int) (1.5 * capacity);
        Object[] array2 = new Object[capacity];
        for (int i = 0; i < size; i++) {
            array2[i] = array[i];
        }
        array = array2;
    }

    /**
     * Checks if the specified index is within the valid range.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("error");
        }
    }

    /**
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }


}
