package org.example;

import java.io.*;
import java.util.Scanner;

public class ExceptionHandlingExample {

    public void run() {
        System.out.println("Exception Handling Examples in Java:");

        basicTryCatch();
        multipleCatchBlocks();
        finallyBlock();
        tryWithResources();
        customExceptions();
        exceptionPropagation();
    }

    private void basicTryCatch() {
        System.out.println("\n*********************** Basic Try-Catch ***********************");
        System.out.println("Explanation: A try block contains code that might throw an exception, and the catch block handles it.");
        System.out.println("Pros: Prevents program crashes and allows graceful error handling.");
        System.out.println("Cons: Can make code more verbose if overused.");
        System.out.println("Best used when: Dealing with operations that might fail, like file I/O or network operations.");

        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught an ArithmeticException: " + e.getMessage());
        }
    }

    private void multipleCatchBlocks() {
        System.out.println("\n*********************** Multiple Catch Blocks ***********************");
        System.out.println("Explanation: Multiple catch blocks can handle different types of exceptions.");
        System.out.println("Pros: Allows different handling for different exception types.");
        System.out.println("Cons: Can lead to duplicate code if not designed carefully.");
        System.out.println("Best used when: Different types of exceptions require different handling strategies.");

        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[10]); // This will throw an ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught an ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught a general Exception: " + e.getMessage());
        }
    }

    private void finallyBlock() {
        System.out.println("\n*********************** Finally Block ***********************");
        System.out.println("Explanation: The finally block always executes, whether an exception is thrown or not.");
        System.out.println("Pros: Ensures that cleanup code (like closing resources) always runs.");
        System.out.println("Cons: Can make the flow of execution less obvious.");
        System.out.println("Best used when: You need to ensure certain code always runs, regardless of exceptions.");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("nonexistent.txt");
            int data = fis.read();
            System.out.println("Data read: " + data);
        } catch (IOException e) {
            System.out.println("Caught an IOException: " + e.getMessage());
        } finally {
            System.out.println("Executing finally block");
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
        }
    }

    private void tryWithResources() {
        System.out.println("\n*********************** Try-With-Resources ***********************");
        System.out.println("Explanation: Automatically closes resources that implement AutoCloseable interface.");
        System.out.println("Pros: Simplifies resource management and ensures resources are always closed.");
        System.out.println("Cons: Only works with resources that implement AutoCloseable.");
        System.out.println("Best used when: Working with resources that need to be closed, like files or database connections.");

        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Caught a FileNotFoundException: " + e.getMessage());
        }
    }

    private void customExceptions() {
        System.out.println("\n*********************** Custom Exceptions ***********************");
        System.out.println("Explanation: You can create your own exception classes to represent specific error conditions in your application.");
        System.out.println("Pros: Allows for more meaningful and application-specific error handling.");
        System.out.println("Cons: Can lead to a proliferation of exception classes if overused.");
        System.out.println("Best used when: Standard Java exceptions don't adequately describe your error condition.");

        try {
            throw new CustomException("This is a custom exception");
        } catch (CustomException e) {
            System.out.println("Caught a CustomException: " + e.getMessage());
        }
    }

    private void exceptionPropagation() {
        System.out.println("\n*********************** Exception Propagation ***********************");
        System.out.println("Explanation: If an exception is not caught in a method, it's propagated up the call stack.");
        System.out.println("Pros: Allows handling exceptions at the most appropriate level.");
        System.out.println("Cons: Can make it harder to trace the origin of exceptions.");
        System.out.println("Best used when: Lower-level methods can't meaningfully handle an exception.");

        try {
            methodA();
        } catch (Exception e) {
            System.out.println("Caught exception in main method: " + e.getMessage());
        }
    }

    private void methodA() throws Exception {
        methodB();
    }

    private void methodB() throws Exception {
        throw new Exception("Exception thrown in methodB");
    }

    // Custom exception class
    private static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }
}