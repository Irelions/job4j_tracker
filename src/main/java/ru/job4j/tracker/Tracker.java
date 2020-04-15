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
        arrayWithoutNull = Arrays.copyOf(arrayWithoutNull, count);
        return arrayWithoutNull;
    }

    /**
     *
     * @param id
     * @return элемент Item по индексу id
     */
    public Item findById(String id) {
        Item[] array = items;
        Item rzt = null;
        for (int i = 0; i < position; i++) {
            Item temp = array[i];
            if (temp.getId() == id) {
                rzt = temp;
                break;
            }
        }
        return rzt;
    }

    /**
     *
     * @param key
     * @return Массив Item с элементами name == key
     */
    public Item[] findByName(String key) {
        Item[] array = items;
        Item[] arrayFindByName = new Item[items.length];
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

    public static void main(String[] args) {
        Tracker library = new Tracker();
        Item book = new Item("Book");
        library.add(book);
        Item cd = new Item("CD");
        library.add(cd);

        System.out.println(book.getId() + " - " + book.getName());
        System.out.println(cd.getId() + " - " + cd.getName());


    }
}