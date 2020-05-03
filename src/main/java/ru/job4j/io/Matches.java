package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class Matches {
    public static int subMatches(String name, int matches) {
        Scanner input = new Scanner(System.in);
        System.out.println("В стопке " + matches + " спичек. Возьмите от 1 до 3 спичек.");
        System.out.print(name + ": ");
        matches -= Integer.valueOf(input.nextLine());
        return matches;
    }

    public static boolean checkWin(int matches) {
        boolean win = false;
        if (matches == 0 || matches < 0) {
            win = true;
        }
        return win;
    }


    public static void main(String[] args) {
        String player1 = "Player 1";
        String player2 = "Player 2";
        boolean win = false;
        int matches = 11;

        System.out.println(" * * * ИГРА \"11\" * * *");
        while (matches > 0) {
            win = checkWin(subMatches(player1, matches));
            if (win) {
                System.out.println(player1 + " победитель!");
                break;
            }
            win = checkWin(subMatches(player2, matches));
            if (win) {
                System.out.println(player2 + " победитель!");
                break;
            }
        }
    }
}