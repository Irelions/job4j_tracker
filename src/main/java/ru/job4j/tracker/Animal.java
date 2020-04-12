package ru.job4j.tracker;

public class Animal {
    private String name;

    public Animal() {
        System.out.println("load Animal");
    }
    public Animal(String name) {
        this.name = name;
    }
}
