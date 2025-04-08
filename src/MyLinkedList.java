import java.util.Iterator;
public class MyLinkedList<T>  implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    private static class MyNode<E>{
        E data;
        MyNode<E> next;
        MyNode<E> prev;
        MyNode(E data){
            this.data = data;
        }
    }

    public T get(int index) {
        return getNode(index).data;
    }

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

    public void addLast(T item){
        add(item);
    }

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

    public void set(int index, T item){
        MyNode<T> current = getNode(index);
        current.data = item;
    }

    public T getFirst(){
        if(isEmpty()){
            throw new IllegalStateException("empty");
        }
        return head.data;
    }

    public T getLast(){
        if(isEmpty()){
            throw new IllegalStateException("empty");
        }
        return tail.data;
    }
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
    }
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

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (MyNode<T> current = head; current != null; current = current.next) {
            array[index++] = current.data;
        }
        return array;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

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