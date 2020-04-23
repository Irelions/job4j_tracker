package ru.job4j.strategy;

public class Paint {

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        Triangle triangle = new Triangle();
        Square square = new Square();
        paint.draw(triangle);
        System.out.println();
        paint.draw(square);

    }



}
