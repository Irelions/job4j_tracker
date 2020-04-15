package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void testFindAll() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("One");
        Item itemTwo = new Item("Two");
        Item itemThree = new Item("Three");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);

        Item[] result = tracker.findAll();
        int size = 3;
        assertEquals(result.length, size);
    }

    @Test
    public void testFindByName() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("Book");
        Item itemTwo = new Item("Book");
        Item itemThree = new Item("CD");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);

        Item[] result = tracker.findByName("Book");
        int size = 2;
        assertEquals(result.length, size);
        assertThat(result[0].getId(), is(itemOne.getId()));
        assertThat(result[1].getId(), is(itemTwo.getId()));
    }

    @Test
    public void testFindById() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("One");
        Item itemTwo = new Item("Two");
        tracker.add(itemOne);
        tracker.add(itemTwo);

        Item result = tracker.findById(itemOne.getId());
        assertThat(result.getId(), is(itemOne.getId()));
    }
}