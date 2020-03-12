package com.interview.reflect;

public class Robot {
    static {
        System.out.println("Hello Robot");
    }

    private String name;

    private String sayHello(String tag) {
        return "Hello " + tag;
    }

    private String getName() {
        System.out.println("name is " + name);
        return name;
    }
}
