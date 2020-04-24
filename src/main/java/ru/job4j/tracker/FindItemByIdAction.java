package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {

    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter ID: ");
        String id = input.askStr("Enter ID: ");
        Item itemTemp = tracker.findById(id);
        if (itemTemp == null) {
            System.out.println(id + " not found.");
        } else {
            System.out.println(itemTemp);
        }
        System.out.println();
        return true;
    }
}
