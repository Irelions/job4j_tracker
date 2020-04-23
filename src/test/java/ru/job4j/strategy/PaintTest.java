package ru.job4j.strategy;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.StringJoiner;

public class PaintTest {
    @Test
    public void testDrawSquare() {
        //Получаем ссылку на стандартный вывод в консоль
        PrintStream stdout = System.out;
        //Создаем буфер для хранения вывода
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод в памятьдля тестирования.
        System.setOut(new PrintStream(out));
        //Выполняем действия пишущее в консоль
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
        //Возращаем обратно стандартный вывод в консоле
        System.setOut(stdout);

    }

    @Test
    public void testDrawTriangle() {

        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
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
        //Возращаем обратно стандартный вывод в консоле
        System.setOut(stdout);
    }

}