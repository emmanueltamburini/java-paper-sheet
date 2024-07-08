package org.example;

import java.util.Scanner;
import java.util.*;

public class DataStructuresTiming {
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWhich data structure example do you want to run?");
            System.out.println("1. Array");
            System.out.println("2. ArrayList");
            System.out.println("3. LinkedList");
            System.out.println("4. HashSet");
            System.out.println("5. TreeSet");
            System.out.println("6. HashMap");
            System.out.println("7. TreeMap");
            System.out.println("8. Stack");
            System.out.println("9. Queue");
            System.out.println("10. Deque");
            System.out.println("0. Exit");
            System.out.println("Enter the number of the example you want to run:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    new ArrayExample().run();
                    break;
                case 2:
                    new ArrayListExample().run();
                    break;
                case 3:
                    new LinkedListExample().run();
                    break;
                case 4:
                    new HashSetExample().run();
                    break;
                case 5:
                    new TreeSetExample().run();
                    break;
                case 6:
                    new HashMapExample().run();
                    break;
                case 7:
                    new TreeMapExample().run();
                    break;
                case 8:
                    new StackExample().run();
                    break;
                case 9:
                    new QueueExample().run();
                    break;
                case 10:
                    new DequeExample().run();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("\nPress Enter to continue...");
            scanner.nextLine(); // Consume the newline
            scanner.nextLine(); // Wait for user input
        }
    }
}

class ArrayExample {
    public void run() {
        System.out.println("\n--- Array Example ---");
        int[] arr = {1, 2, 3, 4, 5};

        // Read
        long startTime = System.nanoTime();
        int element = arr[2];
        long endTime = System.nanoTime();
        System.out.printf("Read element at index 2: %d, Time taken: %d ns%n", element, (endTime - startTime));

        // Modify
        startTime = System.nanoTime();
        arr[2] = 30;
        endTime = System.nanoTime();
        System.out.printf("After modifying index 2: %s, Time taken: %d ns%n", Arrays.toString(arr), (endTime - startTime));

        // Delete (simulate by shifting)
        startTime = System.nanoTime();
        for (int i = 2; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
        endTime = System.nanoTime();
        System.out.printf("After 'deleting' index 2: %s, Time taken: %d ns%n", Arrays.toString(arr), (endTime - startTime));
    }
}

class ArrayListExample {
    public void run() {
        System.out.println("\n--- ArrayList Example ---");
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Read
        long startTime = System.nanoTime();
        int element = list.get(2);
        long endTime = System.nanoTime();
        System.out.printf("Read element at index 2: %d, Time taken: %d ns%n", element, (endTime - startTime));

        // Modify
        startTime = System.nanoTime();
        list.set(2, 30);
        endTime = System.nanoTime();
        System.out.printf("After modifying index 2: %s, Time taken: %d ns%n", list, (endTime - startTime));

        // Delete
        startTime = System.nanoTime();
        list.remove(2);
        endTime = System.nanoTime();
        System.out.printf("After deleting index 2: %s, Time taken: %d ns%n", list, (endTime - startTime));
    }
}

class LinkedListExample {
    public void run() {
        System.out.println("\n--- LinkedList Example ---");
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Read
        long startTime = System.nanoTime();
        int element = list.get(2);
        long endTime = System.nanoTime();
        System.out.printf("Read element at index 2: %d, Time taken: %d ns%n", element, (endTime - startTime));

        // Modify
        startTime = System.nanoTime();
        list.set(2, 30);
        endTime = System.nanoTime();
        System.out.printf("After modifying index 2: %s, Time taken: %d ns%n", list, (endTime - startTime));

        // Delete
        startTime = System.nanoTime();
        list.remove(2);
        endTime = System.nanoTime();
        System.out.printf("After deleting index 2: %s, Time taken: %d ns%n", list, (endTime - startTime));
    }
}

class HashSetExample {
    public void run() {
        System.out.println("\n--- HashSet Example ---");
        HashSet<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));

        // Read (check if exists)
        long startTime = System.nanoTime();
        boolean contains = set.contains(3);
        long endTime = System.nanoTime();
        System.out.printf("Contains 3: %b, Time taken: %d ns%n", contains, (endTime - startTime));

        // Modify (remove and add)
        startTime = System.nanoTime();
        set.remove(3);
        set.add(30);
        endTime = System.nanoTime();
        System.out.printf("After modifying 3 to 30: %s, Time taken: %d ns%n", set, (endTime - startTime));

        // Delete
        startTime = System.nanoTime();
        set.remove(4);
        endTime = System.nanoTime();
        System.out.printf("After deleting 4: %s, Time taken: %d ns%n", set, (endTime - startTime));
    }
}

class TreeSetExample {
    public void run() {
        System.out.println("\n--- TreeSet Example ---");
        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));

        // Read (check if exists)
        long startTime = System.nanoTime();
        boolean contains = set.contains(3);
        long endTime = System.nanoTime();
        System.out.printf("Contains 3: %b, Time taken: %d ns%n", contains, (endTime - startTime));

        // Modify (remove and add)
        startTime = System.nanoTime();
        set.remove(3);
        set.add(30);
        endTime = System.nanoTime();
        System.out.printf("After modifying 3 to 30: %s, Time taken: %d ns%n", set, (endTime - startTime));

        // Delete
        startTime = System.nanoTime();
        set.remove(4);
        endTime = System.nanoTime();
        System.out.printf("After deleting 4: %s, Time taken: %d ns%n", set, (endTime - startTime));
    }
}

class HashMapExample {
    public void run() {
        System.out.println("\n--- HashMap Example ---");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // Read
        long startTime = System.nanoTime();
        int value = map.get("two");
        long endTime = System.nanoTime();
        System.out.printf("Value for key 'two': %d, Time taken: %d ns%n", value, (endTime - startTime));

        // Modify
        startTime = System.nanoTime();
        map.put("two", 20);
        endTime = System.nanoTime();
        System.out.printf("After modifying 'two': %s, Time taken: %d ns%n", map, (endTime - startTime));

        // Delete
        startTime = System.nanoTime();
        map.remove("three");
        endTime = System.nanoTime();
        System.out.printf("After deleting 'three': %s, Time taken: %d ns%n", map, (endTime - startTime));
    }
}

class TreeMapExample {
    public void run() {
        System.out.println("\n--- TreeMap Example ---");
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // Read
        long startTime = System.nanoTime();
        int value = map.get("two");
        long endTime = System.nanoTime();
        System.out.printf("Value for key 'two': %d, Time taken: %d ns%n", value, (endTime - startTime));

        // Modify
        startTime = System.nanoTime();
        map.put("two", 20);
        endTime = System.nanoTime();
        System.out.printf("After modifying 'two': %s, Time taken: %d ns%n", map, (endTime - startTime));

        // Delete
        startTime = System.nanoTime();
        map.remove("three");
        endTime = System.nanoTime();
        System.out.printf("After deleting 'three': %s, Time taken: %d ns%n", map, (endTime - startTime));
    }
}

class StackExample {
    public void run() {
        System.out.println("\n--- Stack Example ---");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Read
        long startTime = System.nanoTime();
        int top = stack.peek();
        long endTime = System.nanoTime();
        System.out.printf("Top element: %d, Time taken: %d ns%n", top, (endTime - startTime));

        // Modify (pop and push)
        startTime = System.nanoTime();
        stack.pop();
        stack.push(30);
        endTime = System.nanoTime();
        System.out.printf("After modifying top: %s, Time taken: %d ns%n", stack, (endTime - startTime));

        // Delete
        startTime = System.nanoTime();
        stack.pop();
        endTime = System.nanoTime();
        System.out.printf("After deleting top: %s, Time taken: %d ns%n", stack, (endTime - startTime));
    }
}

class QueueExample {
    public void run() {
        System.out.println("\n--- Queue Example ---");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        // Read
        long startTime = System.nanoTime();
        int front = queue.peek();
        long endTime = System.nanoTime();
        System.out.printf("Front element: %d, Time taken: %d ns%n", front, (endTime - startTime));

        // Modify (remove and add)
        startTime = System.nanoTime();
        queue.poll();
        queue.offer(30);
        endTime = System.nanoTime();
        System.out.printf("After modifying: %s, Time taken: %d ns%n", queue, (endTime - startTime));

        // Delete
        startTime = System.nanoTime();
        queue.poll();
        endTime = System.nanoTime();
        System.out.printf("After deleting front: %s, Time taken: %d ns%n", queue, (endTime - startTime));
    }
}

class DequeExample {
    public void run() {
        System.out.println("\n--- Deque Example ---");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);

        // Read
        long startTime = System.nanoTime();
        int front = deque.peekFirst();
        int rear = deque.peekLast();
        long endTime = System.nanoTime();
        System.out.printf("Front element: %d, Rear element: %d, Time taken: %d ns%n", front, rear, (endTime - startTime));

        // Modify
        startTime = System.nanoTime();
        deque.pollFirst();
        deque.offerFirst(10);
        deque.pollLast();
        deque.offerLast(30);
        endTime = System.nanoTime();
        System.out.printf("After modifying: %s, Time taken: %d ns%n", deque, (endTime - startTime));

        // Delete
        startTime = System.nanoTime();
        deque.pollFirst();
        endTime = System.nanoTime();
        System.out.printf("After deleting front: %s, Time taken: %d ns%n", deque, (endTime - startTime));
    }
}

