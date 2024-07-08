package org.example;
import java.util.*;

public class DataStructuresComparison {
    public void run() {
        System.out.println("Data Structures Comparison in Java:");

        // Array
        System.out.println("Array:");
        System.out.println("Inner Implementation: Fixed-size contiguous memory");
        System.out.println("Insertion at end: O(1), at start/middle: O(n)");
        System.out.println("Removal: O(n)");
        System.out.println("Modification: O(1)");
        System.out.println("Reading: O(1)");
        System.out.println("Ordering: Fixed order, based on indices");
        System.out.println("Common Usage: Static lists, fixed-size data");
        System.out.println("Pros: Fast read and modify, low memory overhead");
        System.out.println("Cons: Fixed size, expensive insertions and deletions at start/middle");
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Array elements: " + Arrays.toString(array));
        System.out.println();

        // ArrayList
        System.out.println("ArrayList:");
        System.out.println("Inner Implementation: Resizable array");
        System.out.println("Insertion at end: O(1) amortized, at start/middle: O(n)");
        System.out.println("Removal: O(n)");
        System.out.println("Modification: O(1)");
        System.out.println("Reading: O(1)");
        System.out.println("Ordering: Preserves insertion order");
        System.out.println("Common Usage: Dynamic arrays, frequent read operations");
        System.out.println("Pros: Dynamic resizing, fast read and modify");
        System.out.println("Cons: Expensive insertions and deletions at start/middle, may waste space due to resizing");
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("ArrayList elements: " + arrayList);
        System.out.println();

        // LinkedList
        System.out.println("LinkedList:");
        System.out.println("Inner Implementation: Doubly-linked list");
        System.out.println("Insertion: O(1)");
        System.out.println("Removal: O(1)");
        System.out.println("Modification: O(n) (traversal required)");
        System.out.println("Reading: O(n) (traversal required)");
        System.out.println("Ordering: Preserves insertion order");
        System.out.println("Common Usage: Frequent insertions/deletions, queues");
        System.out.println("Pros: Efficient insertions and deletions");
        System.out.println("Cons: High memory overhead, slow read and modify");
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("A", "B", "C"));
        System.out.println("LinkedList elements: " + linkedList);
        System.out.println();

        // HashSet
        System.out.println("HashSet:");
        System.out.println("Inner Implementation: Hash table");
        System.out.println("Insertion: O(1)");
        System.out.println("Removal: O(1)");
        System.out.println("Modification: N/A");
        System.out.println("Reading: O(1)");
        System.out.println("Ordering: Unordered");
        System.out.println("Common Usage: Unique elements, fast access");
        System.out.println("Pros: Fast insertion, deletion, and lookup");
        System.out.println("Cons: Unordered, no duplicates allowed");
        HashSet<String> hashSet = new HashSet<>(Arrays.asList("apple", "banana", "cherry"));
        System.out.println("HashSet elements: " + hashSet);
        System.out.println();

        // TreeSet
        System.out.println("TreeSet:");
        System.out.println("Inner Implementation: Red-black tree");
        System.out.println("Insertion: O(log n)");
        System.out.println("Removal: O(log n)");
        System.out.println("Modification: N/A");
        System.out.println("Reading: O(log n)");
        System.out.println("Ordering: Sorted order");
        System.out.println("Common Usage: Sorted unique elements");
        System.out.println("Pros: Sorted elements, no duplicates allowed");
        System.out.println("Cons: Slower than HashSet, high memory overhead");
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(30, 10, 20));
        System.out.println("TreeSet elements: " + treeSet);
        System.out.println();

        // HashMap
        System.out.println("HashMap:");
        System.out.println("Inner Implementation: Hash table");
        System.out.println("Insertion: O(1)");
        System.out.println("Removal: O(1)");
        System.out.println("Modification: O(1)");
        System.out.println("Reading: O(1)");
        System.out.println("Ordering: Unordered");
        System.out.println("Common Usage: Key-value pairs, fast access");
        System.out.println("Pros: Fast insertion, deletion, and lookup");
        System.out.println("Cons: Unordered, no null keys/values allowed");
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "one");
        hashMap.put(2, "two");
        hashMap.put(3, "three");
        System.out.println("HashMap elements: " + hashMap);
        System.out.println();

        // TreeMap
        System.out.println("TreeMap:");
        System.out.println("Inner Implementation: Red-black tree");
        System.out.println("Insertion: O(log n)");
        System.out.println("Removal: O(log n)");
        System.out.println("Modification: O(log n)");
        System.out.println("Reading: O(log n)");
        System.out.println("Ordering: Sorted order");
        System.out.println("Common Usage: Sorted key-value pairs");
        System.out.println("Pros: Sorted elements, allows null keys/values");
        System.out.println("Cons: Slower than HashMap, high memory overhead");
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("B", 2);
        treeMap.put("A", 1);
        treeMap.put("C", 3);
        System.out.println("TreeMap elements: " + treeMap);
        System.out.println();

        // Stack
        System.out.println("Stack:");
        System.out.println("Inner Implementation: Resizable array or linked list");
        System.out.println("Insertion: O(1)");
        System.out.println("Removal: O(1)");
        System.out.println("Modification: O(1)");
        System.out.println("Reading: O(n) for search");
        System.out.println("Ordering: LIFO (Last In First Out)");
        System.out.println("Common Usage: Backtracking, expression evaluation");
        System.out.println("Pros: Simple to use, efficient for LIFO operations");
        System.out.println("Cons: Limited to LIFO operations, no random access");
        Stack<String> stack = new Stack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        System.out.println("Stack elements: " + stack);
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
        System.out.println();

        // Queue
        System.out.println("Queue:");
        System.out.println("Inner Implementation: Linked list or array");
        System.out.println("Insertion: O(1)");
        System.out.println("Removal: O(1)");
        System.out.println("Modification: N/A");
        System.out.println("Reading: O(n) for search");
        System.out.println("Ordering: FIFO (First In First Out)");
        System.out.println("Common Usage: Task scheduling, breadth-first search");
        System.out.println("Pros: Simple to use, efficient for FIFO operations");
        System.out.println("Cons: Limited to FIFO operations, no random access");
        Queue<Double> queue = new LinkedList<>();
        queue.add(1.1);
        queue.add(2.2);
        queue.add(3.3);
        System.out.println("Queue elements: " + queue);
        System.out.println("Removed element: " + queue.poll());
        System.out.println("Queue after poll: " + queue);
        System.out.println();

        // Deque
        System.out.println("Deque:");
        System.out.println("Inner Implementation: Linked list or array");
        System.out.println("Insertion: O(1) at both ends");
        System.out.println("Removal: O(1) at both ends");
        System.out.println("Modification: N/A");
        System.out.println("Reading: O(n) for search");
        System.out.println("Ordering: Allows insertion/removal at both ends");
        System.out.println("Common Usage: Double-ended queue operations, sliding window algorithms");
        System.out.println("Pros: Flexible, allows insertion and deletion at both ends");
        System.out.println("Cons: No random access, higher memory overhead");
        Deque<Character> deque = new LinkedList<>();
        deque.addFirst('X');
        deque.addLast('Y');
        deque.addFirst('W');
        System.out.println("Deque elements: " + deque);
        System.out.println("Removed first element: " + deque.removeFirst());
        System.out.println("Removed last element: " + deque.removeLast());
        System.out.println("Deque after removals: " + deque);
        System.out.println();
    }
}
