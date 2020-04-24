package ru.job4j.tracker;

public class ShowAllAction implements UserAction {

    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] itemsTemp = tracker.findAll();
        for (int i = 0; i < itemsTemp.length; i++) {
            System.out.println(itemsTemp[i]);
        }
        System.out.println();
        return true;
    }
}
