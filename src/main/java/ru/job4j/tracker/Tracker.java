package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {

    private final Item[] items = new Item[100];
    private int position = 0;

    public int getSize() {
        return position;
    }

    /**
     *
     * @param item
     * @return добавляет в Item[] новый элемент
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     *
     * @return Массив без нулевых элементов
     */
    public Item[] findAll() {
        Item[] array = items;
        Item[] arrayWithoutNull = new Item[items.length];
        int count = 0;
        for (int i = 0; i < position; i++) {
            Item temp = array[i];
            if (temp != null) {
                arrayWithoutNull[count] = temp;
                count++;
            }
        }
        return Arrays.copyOf(arrayWithoutNull, count);
    }

    /**
     *
     * @param id
     * @return элемент Item по индексу id
     */
    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    /**
     *
     * @param key
     * @return Массив Item с элементами name == key
     */
    public Item[] findByName(String key) {
        Item[] array = items;
        Item[] arrayFindByName = new Item[position];
        int count = 0;
        for (int i = 0; i < position; i++) {
            Item temp = array[i];
            if (temp.getName().equals(key)) {
                arrayFindByName[count] = temp;
                count++;
            }
        }
        arrayFindByName = Arrays.copyOf(arrayFindByName, count);
        return arrayFindByName;
    }

    /**
     *
     * @param id
     * @param item
     * @return Состоялась ли замена в Items[] по индексу id элементом Item
     */
    public boolean replace(String id, Item item) {
        boolean rzl = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            rzl = true;
        }
        return rzl;
    }

    public boolean delete(String id) {
        boolean rzl = false;
        int index = indexOf(id);
        if (index != -1) {
            items[index] = null;
            System.arraycopy(items, index + 1, items, index, position - (index + 1));
            items[position - 1] = null;
            position--;
            rzl = true;
        }
        return rzl;
    }

    /**
     *
     * @param id
     * @return индекс элемента массива Item[] (поиск по id)
     */
    private int indexOf(String id) {
        int rzl = -1;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                rzl = i;
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
        long tmp = rm.nextLong();
        if (tmp < 0) {
            tmp *= -1;
        }
        return String.valueOf(tmp + System.currentTimeMillis());
    }
}