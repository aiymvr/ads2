public class Main {
    public static void main(String[] args){
        testMyStack();
        testMyQueue();
        testMyMinHeap();

    }
    private static void testMyStack(){
        MyStack<Integer> stack = new MyStack<>();
        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        System.out.println("Size: " + stack.size());
        System.out.println("Is it empty? " + stack.empty());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println();
    }

    private static void testMyQueue(){
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(4);
        queue.enqueue(8);
        queue.enqueue(12);
        queue.enqueue(16);
        System.out.println("Size: " + queue.size());
        System.out.println("Is it empty? " + queue.empty());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Enqueue: " + queue.enqueue(5));
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println();
    }
    private static void testMyMinHeap(){
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(5);
        minHeap.insert(32);
        minHeap.insert(7);;
        minHeap.insert(42);
        minHeap.insert(15);
        System.out.println("Size: " + minHeap.size());
        System.out.println("Is it empty? " + minHeap.empty());
        System.out.println("Minimum:" + minHeap.getMin());
        System.out.println("Extract min: "+ minHeap.extractMin());
        System.out.println("Min after extracting: " + minHeap.getMin());

    }
}

