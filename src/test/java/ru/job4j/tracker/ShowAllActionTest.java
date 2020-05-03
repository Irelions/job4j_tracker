package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ShowAllActionTest {
@Test
    public void testExecute() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);

        ShowAllAction act = new ShowAllAction();
        act.execute(new StubInput(new String[] {}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", "\r\n\r\n")
                .add(item.getId() + " - " + item.getName())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}