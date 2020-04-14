package ru.job4j.pojo;

public class Store {
    public static void main(String[] args) {
        Product milk = new Product("Milk", 10);
        Product bread = new Product("Bread", 4);
        Product egg = new Product("Egg", 19);

        Product[] prods = new Product[5];

        prods[0] = milk;
        prods[1] = bread;
        prods[2] = egg;


        for (int index = 0; index < prods.length; index++) {
            Product product = prods[index];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println('\n' + "Удаляем значение из ячейки с индексом 1");
        prods[1] = null;
        for (int index = 0; index < prods.length; index++) {
            Product product = prods[index];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println('\n' + "Записывем в ячейку с индексом 1 значение ячейки с индексом 2 и удаляем значение ячейки с индексом 2");
        prods[1] = prods[2];
        prods[2] = null;
        for (int index = 0; index < prods.length; index++) {
            Product product = prods[index];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println('\n' + "Удаляем через метод delete");
        Shop shop = new Shop();
        prods = shop.delete(prods, 0);
        for (int index = 0; index < prods.length; index++) {
            Product product = prods[index];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}

