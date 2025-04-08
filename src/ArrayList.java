public class ArrayList {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        // method add()
        list.add("A");
        list.add("B");
        list.add("C");
        printList(list);

        // method size()
        System.out.println("Size: " + list.size());

        // method get()
        System.out.println("Element at index 1: " + list.get(1));

        // method set()
        list.set(1, "D");
        printList(list);

        // method add(int index, T item)
        list.add(1, "E");
        printList(list);

        // method addFirst()
        list.addFirst("F");
        printList(list);

        // method addLast()
        list.addLast("G");
        printList(list);

        // method getFirst()
        System.out.println("First element: " + list.getFirst());

        // method getLast()
        System.out.println("Last element: " + list.getLast());

        // method remove(int index)
        list.remove(2);
        printList(list);

        // method removeFirst()
        list.removeFirst();
        printList(list);

        // method removeLast()
        list.removeLast();
        printList(list);

        // method sort()
        list.add("B");
        list.add("E");
        list.sort();
        printList(list);

        // method indexOf()
        System.out.println("Index of 'C': " + list.indexOf("C"));

        // method lastIndexOf()
        list.add("C");
        System.out.println("Last index of 'C': " + list.lastIndexOf("C"));

        // method exists()
        System.out.println("Does 'D' exist? " + list.exists("D"));
        System.out.println("Does 'Z' exist? " + list.exists("Z"));

        // method toArray()
        Object[] array = list.toArray();
        printArray(array);

        // method clear()
        list.clear();
        printList(list);
        System.out.println("Is the list empty? " + list.isEmpty());
    }

    private static void printList(MyArrayList<?> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
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