package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8PlusFeaturesExample {
    public void run() {
        System.out.println("Java 8+ Features Examples:");

        lambdaExpressions();
        functionalInterfaces();
        streamAPI();
        optionalClass();
    }

    private void lambdaExpressions() {
        System.out.println("\n*********************** Lambda Expressions ***********************");
        System.out.println("Explanation: Concise way to represent anonymous functions.");
        System.out.println("Pros: More readable and concise code, especially for functional interfaces.");
        System.out.println("Cons: Can be confusing for developers new to functional programming.");
        System.out.println("Best used when: Implementing simple, single-method interfaces.");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(n -> System.out.println(n));
    }

    private void functionalInterfaces() {
        System.out.println("\n*********************** Functional Interfaces ***********************");
        System.out.println("Explanation: Interfaces with a single abstract method, can be implemented using lambda expressions.");
        System.out.println("Pros: Enables functional programming paradigms in Java.");
        System.out.println("Cons: Overuse can lead to less readable code for complex operations.");
        System.out.println("Best used when: You need to pass behavior as an argument to methods.");

        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));
    }

    private void streamAPI() {
        System.out.println("\n*********************** Stream API ***********************");
        System.out.println("Explanation: Provides a declarative approach to processing collections of objects.");
        System.out.println("Pros: Enables functional-style operations on streams of elements, supports parallel execution.");
        System.out.println("Cons: Can be less performant for simple operations on small collections.");
        System.out.println("Best used when: Processing large collections or when you need a pipeline of operations.");

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> filteredNames = names.stream()
                .filter(name -> name.length() > 4)
                .collect(Collectors.toList());
        System.out.println("Filtered names: " + filteredNames);
    }

    private void optionalClass() {
        System.out.println("\n*********************** Optional Class ***********************");
        System.out.println("Explanation: A container object which may or may not contain a non-null value.");
        System.out.println("Pros: Helps avoid null pointer exceptions, forces developers to think about null cases.");
        System.out.println("Cons: Can be overused, leading to unnecessary complexity for simple null checks.");
        System.out.println("Best used when: Dealing with methods that may return null, or for fields that may be null.");

        Optional<String> optional = Optional.of("Hello");
        optional.ifPresent(s -> System.out.println("Value is present: " + s));

        Optional<String> emptyOptional = Optional.empty();
        String result = emptyOptional.orElse("Default Value");
        System.out.println("Result: " + result);
    }
}