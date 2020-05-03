package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindItemByNameActionTest {

    @Test
    public void testExecute() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Tracker traker = new Tracker();
        Item item = new Item("fix bug");
        traker.add(item);

        FindItemByNameAction find = new FindItemByNameAction();
        find.execute(new StubInput(new String[] {}), traker);
        String expect = new StringJoiner(System.lineSeparator(), "", "\r\n\r\n")
                .add(item.getId() + " - " + item.getName())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);

    }
}