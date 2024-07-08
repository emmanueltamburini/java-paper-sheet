package org.example;

import java.lang.annotation.*;
import java.lang.reflect.Method;

public class JavaAnnotationsExample {
    public void run() {
        System.out.println("Java Annotations Examples:");

        builtInAnnotations();
        customAnnotations();
        runtimeAnnotations();
        metaAnnotations();
    }

    private void builtInAnnotations() {
        System.out.println("\n*********************** Built-in Annotations ***********************");
        System.out.println("Explanation: Annotations provided by Java for common use cases.");
        System.out.println("Pros: Standardized, well-supported by tools and frameworks.");
        System.out.println("Cons: Limited to specific use cases.");
        System.out.println("Best used when: You need to provide metadata for the compiler or runtime.");

        @SuppressWarnings("deprecation")
        Object obj = new Integer(10);  // Using deprecated constructor
        System.out.println("Created object: " + obj);
    }

    private void customAnnotations() {
        System.out.println("\n*********************** Custom Annotations ***********************");
        System.out.println("Explanation: User-defined annotations for specific needs.");
        System.out.println("Pros: Can be tailored to specific requirements of your application.");
        System.out.println("Cons: Require custom processing to be useful.");
        System.out.println("Best used when: You need to add metadata specific to your application.");

        @Author(name = "John Doe", date = "2023-07-07")
        class MyClass {
            // Class implementation
        }

        System.out.println("Custom annotation applied to MyClass");
    }

    private void runtimeAnnotations() {
        System.out.println("\n*********************** Runtime Annotations ***********************");
        System.out.println("Explanation: Annotations that can be read at runtime using reflection.");
        System.out.println("Pros: Allow for dynamic behavior based on annotations.");
        System.out.println("Cons: Can impact performance due to reflection.");
        System.out.println("Best used when: You need to make decisions based on annotations at runtime.");

        TestClass testObj = new TestClass();
        for (Method method : testObj.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                Test testAnnotation = method.getAnnotation(Test.class);
                System.out.println("Test method found: " + method.getName() +
                        ", expected to take " + testAnnotation.timeout() + " ms");
            }
        }
    }

    private void metaAnnotations() {
        System.out.println("\n*********************** Meta-Annotations ***********************");
        System.out.println("Explanation: Annotations that can be applied to other annotations.");
        System.out.println("Pros: Allow for fine-grained control over how annotations are used.");
        System.out.println("Cons: Can make the annotation system more complex.");
        System.out.println("Best used when: You need to create annotations with specific behaviors.");

        System.out.println("Example of meta-annotations used in @Author annotation:");
        System.out.println("@Retention(RetentionPolicy.RUNTIME) - Specifies that the annotation should be available at runtime");
        System.out.println("@Target(ElementType.TYPE) - Specifies that the annotation can only be applied to types (classes, interfaces, enums)");
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Author {
        String name();
        String date();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Test {
        long timeout() default 1000L;
    }

    class TestClass {
        @Test(timeout = 5000)
        public void testMethod() {
            // Test implementation
        }
    }
}