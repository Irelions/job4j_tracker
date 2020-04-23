package ru.job4j.strategy;

import java.util.StringJoiner;

public class Square implements Shape {

    @Override
    public String draw() {
        StringJoiner sb = new StringJoiner(System.lineSeparator());
        sb.add("*****");
        sb.add("*****");
        sb.add("*****");
        sb.add("*****");
        sb.add("*****");
        return sb.toString();
    }
}
