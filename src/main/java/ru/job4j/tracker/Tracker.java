package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {

    private List<Item> items = new ArrayList<>();

    /**
     *
     * @param item
     * @return добавляет в List<Item> items новый элемент
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items.add(item);
        return item;
    }

    /**
     *
     * @return List<Item> items
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     *
     * @param id
     * @return элемент List<Item> items по индексу id
     */
    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     *
     * @param key
     * @return List<Item> items с элементами name == key
     */
    public List<Item> findByName(String key) {
        List<Item> array = items;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                array.add(item);
            }
        }
        return array;
    }

    /**
     *
     * @param id
     * @param item
     * @return Состоялась ли замена в List<Item> items по индексу id элементом Item
     */
    public boolean replace(String id, Item item) {
        boolean rzl = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
            rzl = true;
        }
        return rzl;
    }

    /**
     *
     * @param id
     * @return удален ли элеменет по id в List<Item> items
     */
    public boolean delete(String id) {
        boolean rzl = false;
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            rzl = true;
        }
        return rzl;
    }

    /**
     *
     * @param id
     * @return индекс элемента List<Item> items (поиск по id)
     */
    private int indexOf(String id) {
        int rzl = -1;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                rzl = items.indexOf(item);
                break;
            }
        }
        return rzl;
    }

    /**
     *
     * @return уникальный идентификатор
     */
    private String generateId() {
        Random rm = new Random();
        long temp = rm.nextLong();
        if (temp < 0) {
            temp *= -1;
        }
        return String.valueOf(temp + System.currentTimeMillis());
    }
}