package org.example;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class IOOperationsExample {
    public void run() {
        System.out.println("Input/Output (I/O) Operations Examples in Java:");

        fileOperations();
        bufferedOperations();
        nioOperations();
        serializationExample();
    }

    private void fileOperations() {
        System.out.println("\n*********************** File Operations ***********************");
        System.out.println("Explanation: Basic file reading and writing operations.");
        System.out.println("Pros: Simple to use for small files.");
        System.out.println("Cons: Not efficient for large files or when fine-grained control is needed.");
        System.out.println("Best used when: Working with small text files.");

        try {
            FileWriter writer = new FileWriter("test.txt");
            writer.write("Hello, File I/O!");
            writer.close();

            FileReader reader = new FileReader("test.txt");
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void bufferedOperations() {
        System.out.println("\n*********************** Buffered Operations ***********************");
        System.out.println("Explanation: Uses buffer to improve I/O performance.");
        System.out.println("Pros: More efficient for larger files.");
        System.out.println("Cons: Slightly more complex than basic file operations.");
        System.out.println("Best used when: Working with larger files or when performance is important.");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("buffered.txt"));
            writer.write("Hello, Buffered I/O!");
            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader("buffered.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void nioOperations() {
        System.out.println("\n*********************** NIO Operations ***********************");
        System.out.println("Explanation: New I/O API introduced in Java 7 for file operations.");
        System.out.println("Pros: More feature-rich, better performance for large-scale operations.");
        System.out.println("Cons: Can be more complex for simple operations.");
        System.out.println("Best used when: Working with file systems, need for advanced file operations.");

        try {
            Path path = Paths.get("nio.txt");
            Files.write(path, "Hello, NIO!".getBytes());

            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void serializationExample() {
        System.out.println("\n*********************** Serialization ***********************");
        System.out.println("Explanation: Process of converting an object into a byte stream.");
        System.out.println("Pros: Useful for persisting objects, sending objects over network.");
        System.out.println("Cons: Can be a security risk if not handled properly.");
        System.out.println("Best used when: Need to save state of an object or send it over network.");

        try {
            Person person = new Person("Alice", 30);
            FileOutputStream fileOut = new FileOutputStream("person.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();

            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Person deserializedPerson = (Person) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("Deserialized Person: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class Person implements Serializable {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
}