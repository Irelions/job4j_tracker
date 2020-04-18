package ru.job4j.validate;

public class DivByZero {
    public static int div(int first, int second) {
        int rzl = -1;
        if (second == 0) {
            System.out.println("Di by 0, return def value -1");
        } else {
        rzl = first / second;
        }
        return rzl;
    }

    public static void main(String[] args) {
        int rzl = div(10, 0);
        System.out.println(rzl);
    }
}
