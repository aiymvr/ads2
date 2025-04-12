public class Main {
    public static void main(String[] args) {
        System.out.println("Testing MyArrayList...");
        testMyList(new MyArrayList<>());

        System.out.println("\nTesting MyLinkedList...");
        testMyList(new MyLinkedList<>());

        System.out.println("\nTesting MyStack...");
        testMyStack();

        System.out.println("\nTesting MyQueue...");
        testMyQueue();

        System.out.println("\nTesting MyMinHeap...");
        testMyMinHeap();
    }

    /**
     * Tests the functionality of MyList implementations (MyArrayList and MyLinkedList).
     * @param list The MyList implementation to test.
     */
    private static void testMyList(MyList<String> list) {
        // Test add()
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("After add: " + arrayToString(list.toArray()));

        // Test addFirst() and addLast()
        list.addFirst("X");
        list.addLast("Y");
        System.out.println("After addFirst and addLast: " + arrayToString(list.toArray()));

        // Test add(int index, T item)
        list.add(2, "Z");
        System.out.println("After add at index 2: " + arrayToString(list.toArray()));

        // Test get()
        System.out.println("Get index 2: " + list.get(2));

        // Test getFirst() and getLast()
        System.out.println("Get first: " + list.getFirst());
        System.out.println("Get last: " + list.getLast());

        // Test set()
        list.set(2, "W");
        System.out.println("After set index 2 to W: " + arrayToString(list.toArray()));

        // Test remove()
        list.remove(2);
        System.out.println("After remove index 2: " + arrayToString(list.toArray()));

        // Test removeFirst() and removeLast()
        list.removeFirst();
        list.removeLast();
        System.out.println("After removeFirst and removeLast: " + arrayToString(list.toArray()));

        // Test sort()
        list.add("D");
        list.add("E");
        list.sort();
        System.out.println("After sort: " + arrayToString(list.toArray()));

        // Test indexOf() and lastIndexOf()
        System.out.println("Index of B: " + list.indexOf("B")); // 1
        list.add("B");
        System.out.println("Last index of B: " + list.lastIndexOf("B"));

        // Test exists()
        System.out.println("Exists C: " + list.exists("C"));
        System.out.println("Exists Z: " + list.exists("Z"));

        // Test clear()
        list.clear();
        System.out.println("After clear: " + arrayToString(list.toArray()));
        System.out.println("Is empty: " + (list.size() == 0));
    }

    /**
     * Tests the functionality of MyStack.
     */
    private static void testMyStack() {
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

    /**
     * Tests the functionality of MyQueue.
     */
    private static void testMyQueue() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(4);
        queue.enqueue(8);
        queue.enqueue(12);
        queue.enqueue(16);
        System.out.println("Size: " + queue.size());
        System.out.println("Is it empty? " + queue.empty());
        System.out.println("Peek: " + queue.peek());
        queue.enqueue(5);
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println();
    }

    /**
     * Tests the functionality of MyMinHeap.
     */
    private static void testMyMinHeap() {
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(5);
        minHeap.insert(32);
        minHeap.insert(7);
        minHeap.insert(42);
        minHeap.insert(15);
        System.out.println("Size: " + minHeap.size());
        System.out.println("Is it empty? " + minHeap.empty());
        System.out.println("Minimum: " + minHeap.getMin());
        System.out.println("Extract min: " + minHeap.extractMin());
        System.out.println("Min after extracting: " + minHeap.getMin());
    }

    /**
     * Converts an array to a string representation.
     * @param array The array to convert.
     * @return A string representation of the array.
     */
    private static String arrayToString(Object[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}