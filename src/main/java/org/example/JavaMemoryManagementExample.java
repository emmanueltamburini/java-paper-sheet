package org.example;

import java.util.ArrayList;
import java.util.List;

public class JavaMemoryManagementExample {
    public void run() {
        System.out.println("Java Memory Management and Garbage Collection Examples:");

        heapMemory();
        stackMemory();
        garbageCollection();
        outOfMemoryError();
    }

    private void heapMemory() {
        System.out.println("\n*********************** Heap Memory ***********************");
        System.out.println("Explanation: Where objects are allocated in Java.");
        System.out.println("Pros: Dynamic allocation and deallocation, shared among all threads.");
        System.out.println("Cons: Slower access than stack, subject to garbage collection pauses.");
        System.out.println("Best used for: Storing objects and instance variables.");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add("Item " + i);
        }
        System.out.println("Created a large list in heap memory");
    }

    private void stackMemory() {
        System.out.println("\n*********************** Stack Memory ***********************");
        System.out.println("Explanation: Where method invocations and local variables are stored.");
        System.out.println("Pros: Very fast access, automatically managed.");
        System.out.println("Cons: Limited in size, risk of StackOverflowError for deep recursion.");
        System.out.println("Best used for: Storing method frames and local variables.");

        recursiveMethod(0);
    }

    private void recursiveMethod(int depth) {
        if (depth > 1000) return;
        recursiveMethod(depth + 1);
    }

    private void garbageCollection() {
        System.out.println("\n*********************** Garbage Collection ***********************");
        System.out.println("Explanation: Automatic memory management in Java.");
        System.out.println("Pros: Prevents memory leaks, frees developers from manual memory management.");
        System.out.println("Cons: Can cause application pauses, especially for large heaps.");
        System.out.println("Best practices: Minimize object creation, use appropriate GC algorithm for your application.");

        System.gc(); // Request garbage collection (note: this is generally not recommended in production code)
        System.out.println("Requested garbage collection");
    }

    private void outOfMemoryError() {
        System.out.println("\n*********************** OutOfMemoryError ***********************");
        System.out.println("Explanation: Thrown when the Java Virtual Machine cannot allocate an object due to lack of memory.");
        System.out.println("Causes: Leaking resources, allocating very large objects, or inadequate heap size.");
        System.out.println("Prevention: Proper resource management, increasing heap size if necessary.");

        try {
            List<byte[]> list = new ArrayList<>();
            while (true) {
                list.add(new byte[1024 * 1024]); // Allocate 1MB each iteration
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Caught OutOfMemoryError: " + e.getMessage());
        }
    }
}