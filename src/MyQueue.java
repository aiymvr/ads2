public class MyQueue<T extends Comparable<T>>{
    private MyLinkedList<T> list;

    public MyQueue(){
        list = new MyLinkedList<>();
    }

    public int size(){
        return list.size();
    }
    public boolean empty(){
        return list.size() ==0;
    }
    public T peek(){
        return list.get(0);
    }

    public T enqueue(T item){
        list.addLast(item);
        return item;

    }

    public T dequeue(){
        T removingItem = peek();
        list.removeFirst();
        return removingItem;
    }

}
