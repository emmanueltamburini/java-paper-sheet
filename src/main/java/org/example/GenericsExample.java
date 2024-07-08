package org.example;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public void run() {
        System.out.println("Generics Examples in Java:");

        genericClass();
        genericMethod();
        wildcards();
        typeBounds();
    }

    private void genericClass() {
        System.out.println("\n*********************** Generic Class ***********************");
        System.out.println("Explanation: A class that can work with different types.");
        System.out.println("Pros: Type safety, code reusability.");
        System.out.println("Cons: Cannot be used with primitive types directly.");
        System.out.println("Best used when: You need a class to work with various types without code duplication.");

        Box<Integer> intBox = new Box<>(10);
        Box<String> stringBox = new Box<>("Hello Generics");
        System.out.println("Integer Box: " + intBox.get());
        System.out.println("String Box: " + stringBox.get());
    }

    private void genericMethod() {
        System.out.println("\n*********************** Generic Method ***********************");
        System.out.println("Explanation: A method that can work with different types.");
        System.out.println("Pros: Allows writing a single method that can be used for different types.");
        System.out.println("Cons: Can make method signatures more complex.");
        System.out.println("Best used when: You need a method to perform the same operation on different types.");

        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        printArray(intArray);
        printArray(doubleArray);
    }

    private void wildcards() {
        System.out.println("\n*********************** Wildcards ***********************");
        System.out.println("Explanation: Represent an unknown type in generics.");
        System.out.println("Pros: Provides flexibility in using generic types.");
        System.out.println("Cons: Can make code harder to understand if overused.");
        System.out.println("Best used when: You need to work with multiple generic types in a flexible way.");

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);

        printList(intList);
        printList(doubleList);
    }

    private void typeBounds() {
        System.out.println("\n*********************** Type Bounds ***********************");
        System.out.println("Explanation: Restrict the types that can be used in a generic class or method.");
        System.out.println("Pros: Allows you to use methods of the bounding type.");
        System.out.println("Cons: Restricts the flexibility of generics.");
        System.out.println("Best used when: You need to ensure that a generic type has certain capabilities.");

        NumberBox<Integer> intBox = new NumberBox<>(5);
        NumberBox<Double> doubleBox = new NumberBox<>(5.5);
        System.out.println("Integer Box squared: " + intBox.square());
        System.out.println("Double Box squared: " + doubleBox.square());
    }

    // Generic class
    class Box<T> {
        private T t;

        public Box(T t) { this.t = t; }
        public T get() { return t; }
    }

    // Generic method
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Wildcard
    public void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    // Type bounds
    class NumberBox<T extends Number> {
        private T number;

        public NumberBox(T number) { this.number = number; }
        public double square() { return number.doubleValue() * number.doubleValue(); }
    }
}