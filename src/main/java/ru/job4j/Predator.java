package ru.job4j;

public class Predator extends Animal {
    public Predator() {
        super();
        System.out.println("load Predator()");
    }

    public Predator(String name) {
        super(name);
        System.out.println("load Predator(String name)");
    }
}

