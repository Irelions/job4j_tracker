package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;

        System.out.println(" * * * ИГРА \"11\" * * *");
        while (matches > 0) {
            System.out.println("В стопке " + matches + " спичек. Возьмите от 1 до 3 спичек.");
            System.out.print("Player 1: ");
            matches -= Integer.valueOf(input.nextLine());
            if (matches == 0 || matches < 0) {
                System.out.println("Победитель - Player 1");
                break;
            }
            System.out.println("В стопке " + matches + " спичек. Возьмите от 1 до 3 спичек.");
            System.out.print("Player 2: ");
            matches -= Integer.valueOf(input.nextLine());
            if (matches == 0 || matches < 0) {
                System.out.println("Победитель - Player 2");
                break;
            }
            System.out.println();
        }
    }
}
