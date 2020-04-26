package ru.job4j.strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.StringJoiner;

public class PaintTest {
    //Поле содержит дефолтный вывод в консоль
    private final PrintStream stdout = System.out;
    //Буфер для результата
    private  final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void testDrawSquare() {
        new Paint().draw(new Square());
        //Проверяем реультат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(
                    new StringJoiner(System.lineSeparator())
                        .add("*****")
                        .add("*****")
                        .add("*****")
                        .add("*****")
                        .add("*****")
                        .add("")
                        .toString()
                )
        );
    }

    @Test
    public void testDrawTriangle() {
        new Paint().draw(new Triangle());

        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("  *  ")
                                .add(" *** ")
                                .add("*****")
                                .add("")
                                .toString()
                )
        );
    }
}