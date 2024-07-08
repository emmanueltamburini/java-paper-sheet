package org.example;

public class PrimitiveTypesExample {
    public void run() {
        System.out.println("Primitive Types in Java:");

        // byte: 8-bit integer, range: -128 to 127
        byte b = 100;
        System.out.println("byte: 8-bit integer, range: -128 to 127");
        System.out.println("Byte value: " + b);
        System.out.println();

        // short: 16-bit integer, range: -32,768 to 32,767
        short s = 10000;
        System.out.println("short: 16-bit integer, range: -32,768 to 32,767");
        System.out.println("Short value: " + s);
        System.out.println();

        // int: 32-bit integer, range: -2^31 to 2^31-1
        int i = 100000;
        System.out.println("int: 32-bit integer, range: -2^31 to 2^31-1");
        System.out.println("Int value: " + i);
        System.out.println();

        // long: 64-bit integer, range: -2^63 to 2^63-1
        long l = 10000000000L;
        System.out.println("long: 64-bit integer, range: -2^63 to 2^63-1");
        System.out.println("Long value: " + l);
        System.out.println();

        // float: 32-bit floating point, range: approximately ±3.40282347E+38F
        float f = 10.5f;
        System.out.println("float: 32-bit floating point, range: approximately ±3.40282347E+38F");
        System.out.println("Float value: " + f);
        System.out.println();

        // double: 64-bit floating point, range: approximately ±1.79769313486231570E+308
        double d = 10.5;
        System.out.println("double: 64-bit floating point, range: approximately ±1.79769313486231570E+308");
        System.out.println("Double value: " + d);
        System.out.println();

        // char: 16-bit Unicode character, range: '\u0000' (or 0) to '\uffff' (or 65,535 inclusive)
        char c = 'A';
        System.out.println("char: 16-bit Unicode character, range: '\\u0000' (or 0) to '\\uffff' (or 65,535 inclusive)");
        System.out.println("Char value: " + c);
        System.out.println();

        // boolean: can hold only two values: true or false
        boolean bool = true;
        System.out.println("boolean: can hold only two values: true or false");
        System.out.println("Boolean value: " + bool);
        System.out.println();
    }
}

