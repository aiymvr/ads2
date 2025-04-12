 **ADS2 Project**

## **Overview**
This project implements custom data structures in Java, including:
- **MyArrayList**: A dynamic array implementation.
- **MyLinkedList**: A doubly linked list implementation.
- **MyStack**: A stack implementation based on `MyArrayList`.
- **MyQueue**: A queue implementation based on `MyLinkedList`.
- **MyMinHeap**: A min-heap implementation based on `MyArrayList`.

Each data structure is designed to provide efficient operations and is thoroughly tested in the `Main` class.

---

## **Features**

### **MyArrayList**
- Dynamic resizing array.
- Supports operations like adding, removing, and retrieving elements.
- Implements the `MyList` interface.

### **MyLinkedList**
- Doubly linked list with `next` and `prev` pointers.
- Efficient for operations like adding/removing elements at the beginning or end.
- Implements the `MyList` interface.

### **MyStack**
- Stack implementation (LIFO - Last In, First Out).
- Built on top of `MyArrayList`.
- Supports operations:
  - `push(T item)`: Adds an item to the stack.
  - `pop()`: Removes and returns the top item.
  - `peek()`: Returns the top item without removing it.

### **MyQueue**
- Queue implementation (FIFO - First In, First Out).
- Built on top of `MyLinkedList`.
- Supports operations:
  - `enqueue(T item)`: Adds an item to the queue.
  - `dequeue()`: Removes and returns the front item.
  - `peek()`: Returns the front item without removing it.

### **MyMinHeap**
- Min-heap implementation.
- Built on top of `MyArrayList`.
- Ensures the smallest element is always at the root.
- Supports operations:
  - `insert(T item)`: Adds an item to the heap.
  - `getMin()`: Returns the smallest element without removing it.
  - `extractMin()`: Removes and returns the smallest element.

---

## **How to Use**

### **1. Clone the Repository**
```bash
git clone <repository-url>
cd <repository-folder>
```

### **2. Compile the Code**
Use the `javac` command to compile all `.java` files:
```bash
javac *.java
```

### **3. Run the Main Class**
Run the `Main` class to test all data structures:
```bash
java Main
```

---

## **Testing**

The `Main` class contains test cases for all data structures:
- **MyArrayList** and **MyLinkedList** are tested using the `testMyList` method.
- **MyStack**, **MyQueue**, and **MyMinHeap** are tested using their respective methods.

### **Example Output**
```
Testing MyArrayList...
After add: [A, B, C]
After addFirst and addLast: [X, A, B, C, Y]
After add at index 2: [X, A, Z, B, C, Y]
Get index 2: Z
Get first: X
Get last: Y
After set index 2 to W: [X, A, W, B, C, Y]
After remove index 2: [X, A, B, C, Y]
After removeFirst and removeLast: [A, B, C]
After sort: [A, B, C, D, E]
Index of B: 1
Last index of B: 5
Exists C: true
Exists Z: false
After clear: []
Is empty: true

Testing MyLinkedList...
After add: [A, B, C]
After addFirst and addLast: [X, A, B, C, Y]
After add at index 2: [X, A, Z, B, C, Y]
Get index 2: Z
Get first: X
Get last: Y
After set index 2 to W: [X, A, W, B, C, Y]
After remove index 2: [X, A, B, C, Y]
After removeFirst and removeLast: [A, B, C]
After sort: [A, B, C, D, E]
Index of B: 1
Last index of B: 5
Exists C: true
Exists Z: false
After clear: []
Is empty: true

Testing MyStack...
Size: 4
Is it empty? false
Pop: 20
Peek: 15

Testing MyQueue...
Size: 4
Is it empty? false
Peek: 4
Dequeue: 4

Testing MyMinHeap...
Size: 5
Is it empty? false
Minimum: 5
Extract min: 5
Min after extracting: 7
```

---

## **Project Structure**
```
src/
├── Main.java          # Main class to test all data structures
├── MyArrayList.java   # Implementation of MyArrayList
├── MyLinkedList.java  # Implementation of MyLinkedList
├── MyStack.java       # Implementation of MyStack
├── MyQueue.java       # Implementation of MyQueue
├── MyMinHeap.java     # Implementation of MyMinHeap
├── MyList.java        # Interface implemented by MyArrayList and MyLinkedList
```

---

## **Requirements**
- Java 8 or higher.




