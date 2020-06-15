package ru.job4j;

import java.util.Arrays;

public class Machine {

    private int[] coins = {10, 5, 2, 1};

    public int[] change(int price, int value) {
        int surrender = value - price;
        int[] rst = new int[Math.abs(surrender)];
        int count = 0;

        if (surrender > 0) {
            for (int coin : coins) {
                while (coin <= surrender) {
                    surrender -= coin;
                    rst[count] = coin;
                    count++;
                }
            }
        } else if (surrender < 0) {
            rst[0] = 0;
            count++;
        }
        return Arrays.copyOf(rst, count);
    }
}
