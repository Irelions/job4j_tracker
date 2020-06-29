package ru.job4j.tracker;

import java.util.List;

public class FindItemByNameAction implements UserAction {

    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter Find name: ");
        List<Item> itemsTemp = tracker.findByName(name);
        if (itemsTemp.size() < 1) {
            System.out.println(name + " not found.");
        } else {
            for (Item item : itemsTemp) {
                System.out.println(item);
            }
        }
        System.out.println();
        return true;
    }
}
