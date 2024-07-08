package org.example;

import java.util.ArrayList;
import java.util.List;

public class OOPExample {
    public void run() {
        System.out.println("Object-Oriented Programming (OOP) Examples in Java:");

        classesAndObjects();
        inheritance();
        polymorphism();
        encapsulation();
        abstraction();
    }

    private void classesAndObjects() {
        System.out.println("\n*********************** Classes and Objects ***********************");
        System.out.println("Explanation: Classes are blueprints for objects. Objects are instances of classes.");
        System.out.println("Pros: Promotes code reusability and organization.");
        System.out.println("Cons: Can lead to over-engineering if not used judiciously.");
        System.out.println("Best used when: Modeling real-world entities or concepts in your program.");

        Car car = new Car("Toyota", "Camry", 2022);
        System.out.println("Created a car object: " + car.getBrand() + " " + car.getModel());
    }

    private void inheritance() {
        System.out.println("\n*********************** Inheritance ***********************");
        System.out.println("Explanation: Allows a class to inherit properties and methods from another class.");
        System.out.println("Pros: Promotes code reuse and establishes a hierarchical relationship between classes.");
        System.out.println("Cons: Can lead to tight coupling and make the system more complex if overused.");
        System.out.println("Best used when: There's a clear 'is-a' relationship between classes.");

        ElectricCar electricCar = new ElectricCar("Tesla", "Model 3", 2023, 75);
        System.out.println("Created an electric car: " + electricCar.getBrand() + " " + electricCar.getModel() +
                " with battery capacity: " + electricCar.getBatteryCapacity() + " kWh");
    }

    private void polymorphism() {
        System.out.println("\n*********************** Polymorphism ***********************");
        System.out.println("Explanation: Allows objects of different classes to be treated as objects of a common superclass.");
        System.out.println("Pros: Provides flexibility and extensibility to the code.");
        System.out.println("Cons: Can make the code harder to understand if overused.");
        System.out.println("Best used when: You need to write code that can work with objects of multiple types.");

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Ford", "Mustang", 2021));
        vehicles.add(new ElectricCar("Nissan", "Leaf", 2022, 62));

        for (Vehicle vehicle : vehicles) {
            vehicle.start(); // Polymorphic method call
        }
    }

    private void encapsulation() {
        System.out.println("\n*********************** Encapsulation ***********************");
        System.out.println("Explanation: Bundles the data and methods that operate on the data within a single unit or object.");
        System.out.println("Pros: Improves security of data and makes the code more modular.");
        System.out.println("Cons: Can lead to many getter and setter methods if not designed carefully.");
        System.out.println("Best used when: You want to hide the internal details of a class and provide a public interface.");

        Car car = new Car("Honda", "Civic", 2020);
        // car.year = 2021; // This would cause a compilation error because year is private
        car.setYear(2021); // This is allowed because we're using the public setter method
        System.out.println("Updated car year: " + car.getYear());
    }

    private void abstraction() {
        System.out.println("\n*********************** Abstraction ***********************");
        System.out.println("Explanation: Hides complex implementation details and shows only the necessary features of an object.");
        System.out.println("Pros: Reduces complexity and isolates the impact of changes.");
        System.out.println("Cons: Can lead to many layers of abstraction, potentially making the system harder to understand.");
        System.out.println("Best used when: You want to provide a simple interface to a complex system.");

        Vehicle vehicle = new Car("Mazda", "CX-5", 2023);
        vehicle.start(); // We don't need to know how the car starts, just that it does
    }
}

// Abstract class demonstrating abstraction
abstract class Vehicle {
    private String brand;
    private String model;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public abstract void start();

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}

// Concrete class extending Vehicle
class Car extends Vehicle {
    private int year;

    public Car(String brand, String model, int year) {
        super(brand, model);
        this.year = year;
    }

    @Override
    public void start() {
        System.out.println("The car is starting...");
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

// Another concrete class demonstrating inheritance and polymorphism
class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(String brand, String model, int year, int batteryCapacity) {
        super(brand, model, year);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void start() {
        System.out.println("The electric car is starting silently...");
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }
}