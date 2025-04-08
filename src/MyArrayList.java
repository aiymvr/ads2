
import java.util.Iterator;
public class MyArrayList<T> implements MyList<T> {
    private Object[] array;
    private int size = 0;
    private int capacity = 5;

    public MyArrayList() {
        array = new Object[capacity];
    }



    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }



    public void add(T newItem) {
        if (size == capacity) {
            increaseBuffer();
        }
        array[size++] = newItem;
    }



    public int size() {
        return size;
    }



    public void set(int index, T item) {
        checkIndex(index);
        array[index] = item;
    }



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




    public void addFirst(T item) {
        add(0, item);
    }



    public void addLast(T item) {
        add(item);
    }



    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("empty");
        }
        return get(0);
    }



    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("empty");
        }
        return get(size - 1);
    }



    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
    }



    public void removeFirst() {
        remove(0);
    }


    public void removeLast() {
        remove(size - 1);
    }


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



    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }


    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }


    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }


    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }


    public void clear() {
        array = new Object[capacity];
        size = 0;
    }


    public Iterator<T> iterator() {
        return new Iterator<T>() {

            public boolean hasNext() {
                return false;
            }


            public T next() {
                return null;
            }
        };
    }


    private void increaseBuffer() {
        capacity = (int) (1.5 * capacity);
        Object[] array2 = new Object[capacity];
        for (int i = 0; i < size; i++) {
            array2[i] = array[i];
        }
        array = array2;
    }


    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("error");
        }
    }


    public boolean isEmpty() {
        return size == 0;
    }


}