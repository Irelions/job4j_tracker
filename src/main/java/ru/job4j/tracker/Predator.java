package ru.job4j.tracker;

public class Predator extends Animal {
    public Predator() {
        super();
        System.out.println("load Predator");
    }

    public Predator(String name) {
        this.name = name;
    }
}

