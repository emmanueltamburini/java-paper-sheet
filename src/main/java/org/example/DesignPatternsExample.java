package org.example;

import java.util.ArrayList;
import java.util.List;

public class DesignPatternsExample {
    public void run() {
        System.out.println("Design Patterns Examples in Java:");

        singletonPattern();
        factoryPattern();
        observerPattern();
        strategyPattern();
    }

    private void singletonPattern() {
        System.out.println("\n*********************** Singleton Pattern ***********************");
        System.out.println("Explanation: Ensures a class has only one instance and provides a global point of access to it.");
        System.out.println("Pros: Guarantees a single instance, global access point, lazy initialization.");
        System.out.println("Cons: Can make unit testing difficult, violates single responsibility principle.");
        System.out.println("Best used when: Exactly one object is needed to coordinate actions across the system.");

        DatabaseConnection instance1 = DatabaseConnection.getInstance();
        DatabaseConnection instance2 = DatabaseConnection.getInstance();
        System.out.println("Are both instances the same? " + (instance1 == instance2));
    }

    private void factoryPattern() {
        System.out.println("\n*********************** Factory Pattern ***********************");
        System.out.println("Explanation: Defines an interface for creating an object, but lets subclasses decide which class to instantiate.");
        System.out.println("Pros: Encapsulates object creation, promotes loose coupling.");
        System.out.println("Cons: Can lead to many subclasses, may complicate the code structure.");
        System.out.println("Best used when: A class can't anticipate the type of objects it needs to create.");

        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("CIRCLE");
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        circle.draw();
        rectangle.draw();
    }

    private void observerPattern() {
        System.out.println("\n*********************** Observer Pattern ***********************");
        System.out.println("Explanation: Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified.");
        System.out.println("Pros: Supports loose coupling, allows for dynamic relationships between objects.");
        System.out.println("Cons: Unexpected updates, potential memory leaks if observers aren't removed properly.");
        System.out.println("Best used when: Changes to one object require changing others, and you don't know how many objects need to be changed.");

        NewsAgency agency = new NewsAgency();
        NewsChannel channel1 = new NewsChannel("Channel 1");
        NewsChannel channel2 = new NewsChannel("Channel 2");

        agency.addObserver(channel1);
        agency.addObserver(channel2);

        agency.setNews("Breaking News: Java 17 released!");
    }

    private void strategyPattern() {
        System.out.println("\n*********************** Strategy Pattern ***********************");
        System.out.println("Explanation: Defines a family of algorithms, encapsulates each one, and makes them interchangeable.");
        System.out.println("Pros: Promotes open/closed principle, enables runtime behavior changes.");
        System.out.println("Cons: Increased number of objects, client must be aware of different strategies.");
        System.out.println("Best used when: You need different variants of an algorithm.");

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Book", 50));
        cart.addItem(new Item("Phone", 500));

        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout();

        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout();
    }
}

// Singleton Pattern
class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {}

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}

// Factory Pattern
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}

// Observer Pattern
interface Observer {
    void update(String news);
}

class NewsChannel implements Observer {
    private String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}

class NewsAgency {
    private String news;
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setNews(String news) {
        this.news = news;
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}

// Strategy Pattern
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit card " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal account " + email);
    }
}

class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

class ShoppingCart {
    List<Item> items;
    PaymentStrategy paymentStrategy;

    public ShoppingCart() {
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        int total = items.stream().mapToInt(Item::getPrice).sum();
        paymentStrategy.pay(total);
    }
}