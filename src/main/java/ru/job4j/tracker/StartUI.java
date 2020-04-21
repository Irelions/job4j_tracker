package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;

       while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                showAll(tracker);
            } else if (select == 2) {
                editItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findeItemsByName(input, tracker);
            } else if (select == 6) {
                System.out.print("Exit Program");
                run = false;
            } else {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        String[] menu = {"Add new Item",
                        "Show all Items",
                        "Edit Item",
                        "Delete Item",
                        "Find Item by Id",
                        "Find Items by name",
                        "Exit Program"};

        for (int index = 0; index < menu.length; index++) {
            System.out.println(index + "." + menu[index]);
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Add - OK!");
        System.out.println();
    }
    public static void showAll(Tracker tracker) {
        System.out.println();
        System.out.println("=== Show all items ===");
        Item[] itemsTemp = tracker.findAll();
        for (int i = 0; i < itemsTemp.length; i++) {
            System.out.println(itemsTemp[i]);
        }
        System.out.println();
    }
    public static void editItem(Input input, Tracker tracker) {
        System.out.println();
        System.out.println("=== Edit item ===");
        String id = input.askStr("Enter ID: ");
        String name = input.askStr("Enter NEW Name: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Replace - OK!");
        } else {
            System.out.println("NO replece!");
        }
        System.out.println();
    }
    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println();
        System.out.println("=== Delete item ===");
        String id = input.askStr("Enter ID: ");
        if (tracker.delete(id)) {
            System.out.println("Delete - OK!");
        } else {
            System.out.println("NO delete!");
        }
        System.out.println();
    }
    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        System.out.print("Enter ID: ");
        String id = input.askStr("Enter ID: ");
        Item itemTemp = tracker.findById(id);
        System.out.println(itemTemp);
        System.out.println();
    }
    public static void findeItemsByName(Input input, Tracker tracker) {
        System.out.println();
        System.out.println("=== Find items by name ===");
        String name = input.askStr("Enter Find name: ");
        Item[] itemsTemp = tracker.findByName(name);
        for (int i = 0; i < itemsTemp.length; i++) {
            System.out.println(itemsTemp[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);

    }
}
