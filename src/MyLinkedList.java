import java.util.Iterator;

/**
 * MyLinkedList is a custom implementation of a doubly linked list.
 *
 *
 * @param <T> the type of elements in this list
 */
public class MyLinkedList<T>  implements MyList<T> {
    private MyNode<T> head; //Ref to the first node
    private MyNode<T> tail; // Ref to the last node
    private int size; //Number of elements in the list

    /**
     * Inner class representing a node in the doubly linked list.
     */
    private static class MyNode<E>{
        E data;
        MyNode<E> next;
        MyNode<E> prev;
        MyNode(E data){
            this.data = data;
        }
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param index the index of the element to retrieve
     * @return the element at the index
     */
    public T get(int index) {
        return getNode(index).data;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param newItem the element to add
     */
    public void add(T newItem) {
        MyNode<T> newNode = new MyNode<>(newItem);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list.
     * If the element is not found, returns -1.
     *
     * @param object the element to search for
     * @return the index of the first occurrence of the element, or -1 if not found
     */
    public int indexOf(Object object) {
        int index = 0;
        for (MyNode<T> current = head; current != null; current = current.next) {
            if ((object == null && current.data == null) || (object != null && object.equals(current.data))) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int size(){
        return size;
    }


    /**
     * Adds an element to the beginning of the list.
     *
     * @param item the element to add
     */
    public void addFirst(T item){
        MyNode<T> newNode = new MyNode<>(item);
        if(head==null){
            head = tail = newNode;
        }
        else{newNode.next = head;
        newNode.prev = null;
        head.prev = newNode;
        head = newNode;}
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param item the element to add
     */
    public void addLast(T item){
        add(item);
    }

    /**
     * Adds an element at the specified index.
     *
     * @param index the index where the element should be added
     * @param item  the element to add
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("error");
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode<T> nextNode = getNode(index);
            MyNode<T> newNode = new MyNode<>(item);
            newNode.next = nextNode;
            newNode.prev = nextNode.prev;
            nextNode.prev.next = newNode;
            nextNode.prev = newNode;
            size++;
        }
    }

    /**
     * Updates the element at the specified index.
     *
     * @param index the index of the element to update
     * @param item  the new value to set
     */
    public void set(int index, T item){
        MyNode<T> current = getNode(index);
        current.data = item;
    }

    /**
     * Retrieves the first element in the list.
     *
     * @return the first element in the list
     * @throws IllegalStateException if the list is empty
     */
    public T getFirst(){
        if(isEmpty()){
            throw new IllegalStateException("empty");
        }
        return head.data;
    }

    /**
     * Retrieves the last element in the list.
     *
     * @return the last element in the list
     * @throws IllegalStateException if the list is empty
     */
    public T getLast(){
        if(isEmpty()){
            throw new IllegalStateException("empty");
        }
        return tail.data;
    }
    /**
     * Removes the element at the specified index.
     *
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void remove(int index){
        MyNode<T> remove = getNode(index);
        if(remove.prev != null){
            remove.prev.next = remove.next;
        }
        else{
            head = remove.next;
        }
        if(remove.next != null){
            remove.next.prev = remove.prev;
        }
        else{
            tail = remove.prev;
        }
        size--;
    }
    /**
     * Removes the first element in the list.
     *
     * @throws IllegalStateException if the list is empty
     */
    public void removeFirst(){
        if(isEmpty()){
            throw new IllegalStateException("empty");
        }
        head=head.next;
        if(head!=null){
            head.prev = null;
        }
        else{
            tail = null;
        }
        size--;
    }
    /**
     * Removes the last element in the list.
     *
     * @throws IllegalStateException if the list is empty
     */
    public void removeLast(){
        if(isEmpty()){
            throw new IllegalStateException("error");
        }
        tail = tail.prev;
        if(tail!=null){
            tail.next = null;
        }
        else{
            head = null;
        }
        size--;
    }

    /**
     * Returns the index of the last occurrence of the specified element in the list.
     *
     * @param object the element to search for
     * @return the index of the last occurrence of the element, or -1 if not found
     */
    public int lastIndexOf(Object object) {
        int index = size - 1;
        for (MyNode<T> current = tail; current != null; current = current.prev) {
            if (current.data.equals(object)) {
                return index;
            }
            index--;
        }
        return -1;
    }
    /**
     * Checks if the specified element exists in the list.
     *
     * @param object the element to check
     * @return true if the element exists, false otherwise
     */
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    /**
     * Converts the list to an array.
     *
     * @return an array containing all elements in the list
     */
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (MyNode<T> current = head; current != null; current = current.next) {
            array[index++] = current.data;
        }
        return array;
    }


    /**
     * Removes all elements from the list.
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Sorts the elements in the list in ascending order.
     * Assumes that the elements implement the Comparable interface.
     */
    public void sort() {
        if (size < 2) {
            return;
        }
        for (MyNode<T> i = head; i != null; i = i.next) {
            for (MyNode<T> j = i.next; j != null; j = j.next) {
                if (((Comparable<T>) i.data).compareTo(j.data) > 0) {
                    T temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
    private MyNode<T> getNode(int index){
        if (index < 0 || index>=size){
            throw new IndexOutOfBoundsException("error");
        }
        MyNode<T> current;
        if(index < size/2){
            current = head;
            for(int i=0; i<index; i++){
                current = current.next;
            }
        }
        else{
            current = tail;
            for(int i=size-1; i>index;i--){
                current = current.prev;
            }
        }
        return current;
    }



}

