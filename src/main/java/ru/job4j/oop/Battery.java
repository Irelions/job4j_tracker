package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int size) {
        this.load = size;
    }

    public void exchenge(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery powerbank = new Battery(4);
        Battery smartphone = new Battery(2);

        System.out.println("Powerbank : " + powerbank.load + " mAh," + " Smartphone : " + smartphone.load + " mAh.");
        powerbank.exchenge(smartphone);
        System.out.println("Зарядка произвдена. Powerbank : " + powerbank.load + " mAh," + " Smartphone : " + smartphone.load + " mAh.");
    }
}
