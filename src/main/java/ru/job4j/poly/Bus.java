package ru.job4j.poly;

public class Bus implements Transport {
    boolean drive = false;
    private int passanger = 0;
    private double fuel = 0;
    private double fuelCost = 40;

    @Override
    public void drive() {
        this.drive = true;
    }

    @Override
    public void passengersUp(int number) {
        this.passanger += number;
    }

    @Override
    public double fuelPrice(double fuelUp) {
        this.fuel += fuelUp;
        return fuelUp * this.fuelCost;
    }
}
