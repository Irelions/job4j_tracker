package ru.job4j.oop;

import java.util.Dictionary;
import java.util.function.DoubleUnaryOperator;

public class DummyDic {

    public String engToRus(String eng) {
        String say = "Неизвестное слово - " + eng;
        return say;
    }

    public static void main(String[] args) {
        DummyDic dummyDic = new DummyDic();

        System.out.println(dummyDic.engToRus("Hello"));
    }
}
