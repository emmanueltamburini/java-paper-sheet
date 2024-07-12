package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            clearScreen();
            System.out.println("Which program do you want to run?");
            System.out.println("0. Sandbox");
            System.out.println("1. Primitive Types Example");
            System.out.println("2. Object-Oriented Programming (OOP)");
            System.out.println("3. Data Structures Example");
            System.out.println("4. Data Structures Comparison");
            System.out.println("5. Data Structures timing menu");
            System.out.println("6. Threading and Concurrency");
            System.out.println("7. Sorting Algorithms");
            System.out.println("8. Exception Handling");
            System.out.println("9. Design Patterns");
            System.out.println("10. Java 8+ Features");
            System.out.println("11. Java Memory Management and Garbage Collection");
            System.out.println("12. Serialization");
            System.out.println("13. Generics");
            System.out.println("14. Input/Output (I/O) Operations");
            System.out.println("15. Java Annotations");
            System.out.println("16. Java Reflection");
            System.out.println("*. Press other option to exit");
            System.out.println("Enter the number of the program you want to run:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    SandBox sandBox = new SandBox();
                    sandBox.run();
                    break;
                case 1:
                    PrimitiveTypesExample primitiveTypesExample = new PrimitiveTypesExample();
                    primitiveTypesExample.run();
                    break;
                case 2:
                    OOPExample oopExample = new OOPExample();
                    oopExample.run();
                    break;
                case 3:
                    DataStructuresExample dataStructuresExample = new DataStructuresExample();
                    dataStructuresExample.run();
                    break;
                case 4:
                    DataStructuresComparison dataStructuresComparison = new DataStructuresComparison();
                    dataStructuresComparison.run();
                    break;
                case 5:
                    DataStructuresTiming dataStructureTimingMenu = new DataStructuresTiming();
                    dataStructureTimingMenu.run();
                    break;
                case 6:
                    ThreadingAndConcurrencyExample threadingAndConcurrencyExample = new ThreadingAndConcurrencyExample();
                    threadingAndConcurrencyExample.run();
                    break;
                case 7:
                    SortingAlgorithmsExample sortingAlgorithmsExample = new SortingAlgorithmsExample();
                    sortingAlgorithmsExample.run();
                    break;
                case 8:
                    ExceptionHandlingExample exceptionHandlingExample = new ExceptionHandlingExample();
                    exceptionHandlingExample.run();
                    break;
                case 9:
                    DesignPatternsExample designPatternsExample = new DesignPatternsExample();
                    designPatternsExample.run();
                    break;
                case 10:
                    Java8PlusFeaturesExample java8PlusFeaturesExample = new Java8PlusFeaturesExample();
                    java8PlusFeaturesExample.run();
                    break;
                case 11:
                    JavaMemoryManagementExample javaMemoryManagementExample = new JavaMemoryManagementExample();
                    javaMemoryManagementExample.run();
                    break;
                case 12:
                    SerializationExample serializationExample = new SerializationExample();
                    serializationExample.run();
                    break;
                case 13:
                    GenericsExample genericsExample = new GenericsExample();
                    genericsExample.run();
                    break;
                case 14:
                    IOOperationsExample ioOperationsExample = new IOOperationsExample();
                    ioOperationsExample.run();
                    break;
                case 15:
                    JavaAnnotationsExample javaAnnotationsExample = new JavaAnnotationsExample();
                    javaAnnotationsExample.run();
                    break;
                case 16:
                    JavaReflectionExample javaReflectionExample = new JavaReflectionExample();
                    javaReflectionExample.run();
                    break;
                default:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
            }
            waitForKeyPress();
            clearScreen();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void waitForKeyPress() {
        System.out.println("Press Enter to continue...");
        try {
            System.in.read();
            while (System.in.available() > 0) {
                System.in.read(); // clear any other input
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
