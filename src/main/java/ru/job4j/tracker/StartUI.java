package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Add - OK!");
                System.out.println();
            } else if (select == 1) {
                System.out.println();
                System.out.println("=== Show all items ===");
                Item[] itemsTemp = tracker.findAll();
                for (int i = 0; i < itemsTemp.length; i++) {
                    System.out.println(i + " - " + itemsTemp[i].getName() + (" (" + itemsTemp[i].getId() + ")"));
                }
                System.out.println();
            } else if (select == 2) {
                System.out.println();
                System.out.println("=== Edit item ===");
                System.out.print("Enter № Item: ");
                int index = Integer.valueOf(scanner.nextLine());
                System.out.print("Enter NEW Name: ");
                String name = scanner.nextLine();
                Item[] itemsTemp = tracker.findAll();
                Item newItem = new Item(name);
                if (tracker.replace(itemsTemp[index].getId(), newItem)) {
                    System.out.println("Replace - OK!");
                } else {
                    System.out.println("NO replece!");
                }
                System.out.println();
            } else if (select == 3) {
                System.out.println();
                System.out.println("=== Delete item ===");
                System.out.print("Enter № Item: ");
                int index = Integer.valueOf(scanner.nextLine());
                Item[] itemsTemp = tracker.findAll();
                if (tracker.delete(itemsTemp[index].getId())) {
                    System.out.println("Delete - OK!");
                } else {
                    System.out.println("NO delete!");
                }
                System.out.println();
            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                System.out.print("Enter ID: ");
                String id = scanner.nextLine();
                Item itemTemp = tracker.findById(id);
                System.out.println(itemTemp.getId() + " - " + itemTemp.getName());
                System.out.println();
            } else if (select == 5) {
                System.out.println();
                System.out.println("=== Find items by name ===");
                System.out.print("Enter Find name: ");
                String name = scanner.nextLine();
                Item[] itemsTemp = tracker.findByName(name);
                for (int i = 0; i < itemsTemp.length; i++) {
                    System.out.println(i + " - " + itemsTemp[i].getName() + (" (" + itemsTemp[i].getId() + ")"));
                }
                System.out.println();
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
