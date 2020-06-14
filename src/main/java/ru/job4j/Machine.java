package ru.job4j;

import java.util.Arrays;

public class Machine {

    private int[] coins = {10, 5, 2, 1};

    public int[] change(int price, int value) {
        int size = value - price;
        int[] rst = new int[size];
        int count = 0;

        for (int index = 0; index < rst.length; index++) {
            if (size > 0) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= size) {
                        size -= coins[j];
                        rst[index] = coins[j];
                        count++;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return Arrays.copyOf(rst, count);
    }
}
