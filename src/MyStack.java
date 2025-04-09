public class MyStack<T> {
    private MyArrayList<T> list;

    public MyStack(){
        list = new MyArrayList<>();
    }

    public T push(T newItem){
        list.add(newItem);
        return newItem;
    }

    public  boolean empty(){
        return list.size() == 0;
    }
    public int size(){
        return list.size();
    }

    public T pop(){
        if(empty()){
            throw new IllegalStateException("error");
        }
        T top = list.get(list.size()-1);
        list.remove(list.size()-1);
        return top;
    }

    public T peek(){
        if(empty()){
            throw new IllegalStateException("error");
        }
        T top = list.get(list.size()-1);
        return top;

    }


}