public class LinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        // add()
        System.out.println("Testing add()");
        list.add("A");
        list.add("B");
        list.add("C");
        printList(list);

        // addFirst()
        System.out.println("\nTesting addFirst()");
        list.addFirst("X");
        printList(list);

        //addLast()
        System.out.println("\nTesting addLast()");
        list.addLast("Y");
        printList(list);

        // add(int index, T item)
        System.out.println("\nTesting add(int index, T item)");
        list.add(2, "Z");
        printList(list);

        // get()
        System.out.println("\nTesting get()");
        System.out.println("Element at index 2: " + list.get(2));

        // set()
        System.out.println("\nTesting set()");
        list.set(2, "W");
        printList(list);

        // getFirst()
        System.out.println("\nTesting getFirst()");
        System.out.println("First element: " + list.getFirst());

        // getLast()
        System.out.println("\nTesting getLast()");
        System.out.println("Last element: " + list.getLast());

        // remove(int index)
        System.out.println("\nTesting remove(int index)");
        list.remove(2);
        printList(list);

        // removeFirst()
        System.out.println("\nTesting removeFirst()");
        list.removeFirst();
        printList(list);

        // removeLast()
        System.out.println("\nTesting removeLast()");
        list.removeLast();
        printList(list);

        // indexOf()
        System.out.println("\nTesting indexOf()");
        System.out.println("Index of 'B': " + list.indexOf("B"));

        // lastIndexOf()
        System.out.println("\nTesting lastIndexOf()");
        list.add("B");
        printList(list);
        System.out.println("Last index of 'B': " + list.lastIndexOf("B"));

        // exists()
        System.out.println("\nTesting exists()");
        System.out.println("Does 'C' exist? " + list.exists("C"));
        System.out.println("Does 'Z' exist? " + list.exists("Z"));

        // toArray()
        System.out.println("\nTesting toArray()");
        Object[] array = list.toArray();
        printArray(array);

        // sort()
        System.out.println("\nTesting sort()");
        list.sort();
        printList(list);

        // clear()
        System.out.println("\nTesting clear()");
        list.clear();
        printList(list);
        System.out.println("Is the list empty? " + list.isEmpty());
    }

    private static void printList(MyLinkedList<?> list) {
        System.out.print("[");
        for (Object item : list.toArray()) {
            System.out.print(item + " ");
        }
        System.out.println("]");
    }

    private static void printArray(Object[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}