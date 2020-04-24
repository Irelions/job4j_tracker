package ru.job4j.tracker;

public class EditItemAction implements UserAction {

    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID: ");
        String name = input.askStr("Enter NEW Name: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Replace - OK!");
        } else {
            System.out.println("NO replece!");
        }
        System.out.println();
        return true;
    }
}
