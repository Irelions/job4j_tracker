package ru.job4j.tracker;

import org.junit.Test;

import java.rmi.server.UnicastRemoteObject;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void testCreateItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void testEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("New Item");
        tracker.add(item);
        String[] answers = {
                item.getId(),
                "replace item"
        };
        StartUI.editItem(new StubInput(answers), tracker);
        Item replace = tracker.findById(item.getId());
        assertThat(replace.getName(), is("replace item"));
    }

    @Test
    public void testDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("New Item");
        tracker.add(item);
        String[] answers = {item.getId()};
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item delete = tracker.findById(answers[0]);
        assertEquals(delete, null);
    }
}