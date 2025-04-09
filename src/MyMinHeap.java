public class MyMinHeap<T extends Comparable<T>>{
    private MyArrayList<T> list;

    public MyMinHeap(){
        list = new MyArrayList<>();
    }

    public int size(){
        return list.size();
    }
    public boolean empty(){
        return list.size() == 0;
    }
    public T getMin(){
        if(empty()){
            throw new IllegalStateException("error");
        }
        return list.get(0);
    }
    public void insert(T item){
        list.add(item);
        traverseUp(list.size()-1);
    }
    public T extractMin(){
        if(empty()){
            throw new IllegalStateException("error");
        }
        T min = list.get(0);
        list.set(0, list.get(list.size()-1));
        list.remove(list.size()-1);
        heapify(0);
        return min;
    }


    private void swap(int i, int j){
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    private void traverseUp(int index){
        while(index>0){
            int parentIndex = parentOf(index);
            if(list.get(index).compareTo(list.get(parentIndex))>=0){
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private int parentOf(int index){
        return (index-1)/2;
    }
    private int leftChildOf(int index){
        return 2*index+1;
    }
    private int rightChildOf(int index){
       return  2*index+2;
    }

    private void heapify(int index){
        int leftChild = leftChildOf(index);
        int rightChild = rightChildOf(index);
        int smallest = index;

        if(leftChild<list.size() && list.get(leftChild).compareTo(list.get(smallest)) < 0){
            smallest = leftChild;
        }
        if(rightChild < list.size() && list.get(rightChild).compareTo(list.get(smallest))<0){
            smallest = rightChild;
        }
        if(smallest !=index){
            swap(index, smallest);
            heapify(smallest);
        }
    }
}