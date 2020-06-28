package ru.job4j.tracker;

import ru.job4j.Item;

import java.util.ArrayList;
import java.util.List;

public class Tracker2 {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
       item.setId(generateId());
        items.add(item);
        return item;
    }

    private String generateId() {
        return String.valueOf(ids++);
    }

    public Item findById(String id) {
        Item rsl = null;
        for (Item tempItem : items) {
            if (tempItem.getId().equals(id)) {
                rsl = tempItem;
            }
        }
        return rsl;
    }
}