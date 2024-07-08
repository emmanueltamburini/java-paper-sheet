package org.example;

import java.util.*;

public class DataStructuresExample {
    public void run() {
        System.out.println("Data Structures in Java:");

        // Array: fixed-size collection of elements of the same type
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Array: fixed-size collection of elements of the same type");
        System.out.println("Array elements: " + Arrays.toString(array));
        System.out.println();

        // ArrayList: resizable array implementation of the List interface
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println("ArrayList: resizable array implementation of the List interface");
        System.out.println("ArrayList elements: " + arrayList);
        System.out.println();

        // LinkedList: doubly-linked list implementation of the List and Deque interfaces
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        System.out.println("LinkedList: doubly-linked list implementation of the List and Deque interfaces");
        System.out.println("LinkedList elements: " + linkedList);
        System.out.println();

        // HashSet: hash table implementation of the Set interface, no duplicates
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("apple");
        hashSet.add("banana");
        hashSet.add("cherry");
        System.out.println("HashSet: hash table implementation of the Set interface, no duplicates");
        System.out.println("HashSet elements: " + hashSet);
        System.out.println();

        // TreeSet: sorted set implementation of the Set interface
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(20);
        System.out.println("TreeSet: sorted set implementation of the Set interface");
        System.out.println("TreeSet elements: " + treeSet);
        System.out.println();

        // HashMap: hash table implementation of the Map interface, key-value pairs
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "one");
        hashMap.put(2, "two");
        hashMap.put(3, "three");
        System.out.println("HashMap: hash table implementation of the Map interface, key-value pairs");
        System.out.println("HashMap elements: " + hashMap);
        System.out.println();

        // TreeMap: sorted map implementation of the Map interface
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("B", 2);
        treeMap.put("A", 1);
        treeMap.put("C", 3);
        System.out.println("TreeMap: sorted map implementation of the Map interface");
        System.out.println("TreeMap elements: " + treeMap);
        System.out.println();

        // Stack: last-in, first-out (LIFO) stack of objects
        Stack<String> stack = new Stack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        System.out.println("Stack: last-in, first-out (LIFO) stack of objects");
        System.out.println("Stack elements: " + stack);
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
        System.out.println();

        // Queue: first-in, first-out (FIFO) queue of objects
        Queue<Double> queue = new LinkedList<>();
        queue.add(1.1);
        queue.add(2.2);
        queue.add(3.3);
        System.out.println("Queue: first-in, first-out (FIFO) queue of objects");
        System.out.println("Queue elements: " + queue);
        System.out.println("Removed element: " + queue.poll());
        System.out.println("Queue after poll: " + queue);
        System.out.println();

        // Deque: double-ended queue allowing insertion and removal at both ends
        Deque<Character> deque = new LinkedList<>();
        deque.addFirst('X');
        deque.addLast('Y');
        deque.addFirst('W');
        System.out.println("Deque: double-ended queue allowing insertion and removal at both ends");
        System.out.println("Deque elements: " + deque);
        System.out.println("Removed first element: " + deque.removeFirst());
        System.out.println("Removed last element: " + deque.removeLast());
        System.out.println("Deque after removals: " + deque);
        System.out.println();
    }
}

