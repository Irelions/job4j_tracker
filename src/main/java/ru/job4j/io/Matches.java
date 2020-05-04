package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    private int matches = 11;

    private static boolean subMatches(Player player, Matches game) {
        Scanner input = new Scanner(System.in);
        boolean win = false;
        int match;
        do {
            System.out.println("В стопке \"" + game.matches + "\" спичек. Возьмите от 1 до 3 спичек.");
            System.out.print(player.getName() + ": ");
            match = Integer.valueOf(input.nextLine());
        } while (match < 0 || match > 3);
        game.matches -= match;
        if (game.matches == 0 || game.matches < 0) {
            System.out.println("Победитель \"" + player.getName() + "\". Игра окончена!");
            win = true;
        }
        return win;
    }

    public void run(Player[] players, Matches game) {
        boolean run = true;
        System.out.println(" * * * ИГРА \"11\" * * *");
        while (run) {
            for (int index = 0; index < players.length; index++) {
                if (subMatches(players[index], game)) {
                    run = false;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Matches game = new Matches();
        Player[] players = {
                new Player("Player 1"),
                new Player("Player 2")
        };
        game.run(players, game);
    }
}