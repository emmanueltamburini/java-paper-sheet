package org.example;

import java.io.*;

public class SerializationExample {
    public void run() {
        System.out.println("Serialization Examples in Java:");

        basicSerialization();
        customSerialization();
        serializationWithInheritance();
        transientKeyword();
    }

    private void basicSerialization() {
        System.out.println("\n*********************** Basic Serialization ***********************");
        System.out.println("Explanation: Process of converting an object into a byte stream.");
        System.out.println("Pros: Allows object persistence and transfer over network.");
        System.out.println("Cons: Can be a security risk if not handled properly.");
        System.out.println("Best used when: You need to save the state of an object or transfer it over network.");

        try {
            FileOutputStream fileOut = new FileOutputStream("files/person.ser");
            Person person = new Person("Alice", 30);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in person.ser");

            FileInputStream fileIn = new FileInputStream("files/person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Person deserializedPerson = (Person) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized Person: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }

    private void customSerialization() {
        System.out.println("\n*********************** Custom Serialization ***********************");
        System.out.println("Explanation: Customizing the serialization process using writeObject and readObject methods.");
        System.out.println("Pros: Allows fine-grained control over serialization process.");
        System.out.println("Cons: Increases complexity, must ensure readObject is consistent with writeObject.");
        System.out.println("Best used when: Default serialization doesn't meet your needs.");

        try {
            CustomPerson person = new CustomPerson("Bob", 25, "password123");
            FileOutputStream fileOut = new FileOutputStream("files/customPerson.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            System.out.println("Custom serialized data is saved in customPerson.ser");

            FileInputStream fileIn = new FileInputStream("files/customPerson.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            CustomPerson deserializedPerson = (CustomPerson) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized CustomPerson: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }

    private void serializationWithInheritance() {
        System.out.println("\n*********************** Serialization with Inheritance ***********************");
        System.out.println("Explanation: How serialization works with class hierarchies.");
        System.out.println("Pros: Allows serialization of complex object hierarchies.");
        System.out.println("Cons: Superclass must be Serializable or have a no-arg constructor.");
        System.out.println("Best used when: Working with inheritance hierarchies that need to be serialized.");

        try {
            Employee employee = new Employee("Charlie", 35, "Manager");
            FileOutputStream fileOut = new FileOutputStream("files/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(employee);
            out.close();
            fileOut.close();
            System.out.println("Serialized employee data is saved in employee.ser");

            FileInputStream fileIn = new FileInputStream("files/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Employee deserializedEmployee = (Employee) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized Employee: " + deserializedEmployee);
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }

    private void transientKeyword() {
        System.out.println("\n*********************** Transient Keyword ***********************");
        System.out.println("Explanation: Marks a field to be skipped during serialization.");
        System.out.println("Pros: Allows exclusion of sensitive or non-serializable fields.");
        System.out.println("Cons: Transient fields will be null or default values after deserialization.");
        System.out.println("Best used when: You have fields that shouldn't or can't be serialized.");

        try {
            TransientExample example = new TransientExample("David", "secret123");
            FileOutputStream fileOut = new FileOutputStream("files/transient.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(example);
            out.close();
            fileOut.close();
            System.out.println("Serialized data with transient field is saved in transient.ser");

            FileInputStream fileIn = new FileInputStream("files/transient.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            TransientExample deserializedExample = (TransientExample) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized TransientExample: " + deserializedExample);
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }

    // Sample classes for serialization examples
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

    static class CustomPerson implements Serializable {
        private String name;
        private int age;
        private transient String password;

        public CustomPerson(String name, int age, String password) {
            this.name = name;
            this.age = age;
            this.password = password;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(encrypt(password));
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            this.password = decrypt((String) in.readObject());
        }

        private String encrypt(String s) {
            return "encrypted:" + s;
        }

        private String decrypt(String s) {
            return s.substring(10);
        }

        @Override
        public String toString() {
            return "CustomPerson{name='" + name + "', age=" + age + ", password='" + password + "'}";
        }
    }

    static class Employee extends Person {
        private String position;

        public Employee(String name, int age, String position) {
            super(name, age);
            this.position = position;
        }

        @Override
        public String toString() {
            return "Employee{" + super.toString() + ", position='" + position + "'}";
        }
    }

    static class TransientExample implements Serializable {
        private String name;
        private transient String password;

        public TransientExample(String name, String password) {
            this.name = name;
            this.password = password;
        }

        @Override
        public String toString() {
            return "TransientExample{name='" + name + "', password='" + password + "'}";
        }
    }
}