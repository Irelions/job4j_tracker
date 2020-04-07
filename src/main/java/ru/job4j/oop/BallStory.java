package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Hare hare = new Hare();
        Wolf2 wolf = new Wolf2();
        Fox fox = new Fox();

        kolobok.run();
        hare.tryEat(kolobok);
        kolobok.run();
        wolf.tryEat(kolobok);
        kolobok.run();
        fox.tryEat(kolobok);
        fox.ate(kolobok);
    }
}
