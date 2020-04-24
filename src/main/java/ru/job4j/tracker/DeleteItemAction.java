package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {

    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID: ");
        if (tracker.delete(id)) {
            System.out.println("Delete - OK!");
        } else {
            System.out.println("NO delete!");
        }
        System.out.println();
        return true;
    }
}
