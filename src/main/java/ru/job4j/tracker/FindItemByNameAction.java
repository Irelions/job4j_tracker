package ru.job4j.tracker;

public class FindItemByNameAction implements UserAction {

    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter Find name: ");
        Item[] itemsTemp = tracker.findByName(name);
        if (itemsTemp.length < 1) {
            System.out.println(name + " not found.");
        } else {
            for (int i = 0; i < itemsTemp.length; i++) {
                System.out.println(itemsTemp[i]);
            }
        }
        System.out.println();
        return true;
    }
}
