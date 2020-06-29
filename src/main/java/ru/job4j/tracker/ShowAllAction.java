package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {

    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> itemsTemp = tracker.findAll();
        for (Item item : itemsTemp) {
            System.out.println(item);
        }
        System.out.println();
        return true;
    }
}
