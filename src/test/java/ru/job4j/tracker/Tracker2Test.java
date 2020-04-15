package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.Item;
import ru.job4j.Tracker2;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Tracker2Test {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker2 tracker = new Tracker2();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
}