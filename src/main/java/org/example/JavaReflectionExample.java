package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.*;

public class JavaReflectionExample {
    public void run() {
        System.out.println("Java Reflection Examples:");

        classInspection();
        methodInvocation();
        fieldManipulation();
        annotationProcessing();
    }

    private void classInspection() {
        System.out.println("\n*********************** Class Inspection ***********************");
        System.out.println("Explanation: Examining class structure at runtime.");
        System.out.println("Pros: Allows for dynamic analysis and manipulation of classes.");
        System.out.println("Cons: Can be slower than direct code, potential security risks if misused.");
        System.out.println("Best used when: Building tools that work with arbitrary classes, like debuggers or ORM frameworks.");

        Class<?> stringClass = String.class;
        System.out.println("Class name: " + stringClass.getName());
        System.out.println("Superclass: " + stringClass.getSuperclass().getName());
        System.out.println("Interfaces implemented:");
        for (Class<?> iface : stringClass.getInterfaces()) {
            System.out.println("  " + iface.getName());
        }
    }

    private void methodInvocation() {
        System.out.println("\n*********************** Method Invocation ***********************");
        System.out.println("Explanation: Calling methods dynamically at runtime.");
        System.out.println("Pros: Allows for flexible, plugin-like architectures.");
        System.out.println("Cons: Type safety is lost, can be slower than direct method calls.");
        System.out.println("Best used when: You need to call methods based on runtime information.");

        try {
            String str = "Hello, Reflection!";
            Method method = String.class.getMethod("length");
            int length = (int) method.invoke(str);
            System.out.println("Length of '" + str + "': " + length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fieldManipulation() {
        System.out.println("\n*********************** Field Manipulation ***********************");
        System.out.println("Explanation: Accessing and modifying fields at runtime.");
        System.out.println("Pros: Allows for dynamic data inspection and modification.");
        System.out.println("Cons: Can break encapsulation, potential for runtime errors.");
        System.out.println("Best used when: Working with legacy systems or creating debugging tools.");

        try {
            ReflectionTarget target = new ReflectionTarget();
            Field field = ReflectionTarget.class.getDeclaredField("privateField");
            field.setAccessible(true);
            System.out.println("Original value: " + field.get(target));
            field.set(target, "Modified value");
            System.out.println("Modified value: " + field.get(target));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void annotationProcessing() {
        System.out.println("\n*********************** Annotation Processing ***********************");
        System.out.println("Explanation: Reading and processing annotations at runtime.");
        System.out.println("Pros: Allows for declarative programming and metadata-driven behavior.");
        System.out.println("Cons: Can be complex to implement, potential for runtime errors if annotations are missing.");
        System.out.println("Best used when: Implementing frameworks or libraries that need to be highly configurable.");

        try {
            Method method = ReflectionTarget.class.getMethod("annotatedMethod");
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                System.out.println("Annotation value: " + annotation.value());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Inner classes for demonstration
    static class ReflectionTarget {
        private String privateField = "Initial value";

        @MyAnnotation("Hello from annotation")
        public void annotatedMethod() {
            // Method implementation
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface MyAnnotation {
        String value();
    }
}