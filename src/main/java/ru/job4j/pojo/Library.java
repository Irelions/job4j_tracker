package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", "Robert Martin");
        Book thinkingInJava = new Book("Thinking in Java", "Bruce Eckel");
        Book essentialAlgorithms = new Book("Essential Algorithms", "Rod Stehpens");
        Book headFirstJava = new Book("Head First Java", "Kathy Sierra");

        Book[] libs = new Book[4];
        libs[0] = cleanCode;
        libs[1] = thinkingInJava;
        libs[2] = essentialAlgorithms;
        libs[3] = headFirstJava;

        for (int index = 0; index < libs.length; index++) {
            Book tempBook = libs[index];
            System.out.println("Book №" + (index + 1) + ": " + tempBook.getName() + " - Author: " + tempBook.getAutor());
        }

        Book temp = libs[0];
        libs[0] = libs[3];
        libs[3] = temp;

        System.out.println('\n' + "Index 0 and 3 are reversed");
        for (int index = 0; index < libs.length; index++) {
            Book tempBook = libs[index];
            System.out.println("Book №" + (index + 1) + ": " + tempBook.getName() + " - Author: " + tempBook.getAutor());
        }

        System.out.println('\n' + "Book Search Clean code");
        for (int index = 0; index < libs.length; index++) {
            Book tempBook = libs[index];
            if (tempBook.getName().equals("Clean code")) {
                System.out.println("Book №" + (index + 1) + ": " + tempBook.getName() + " - Author: " + tempBook.getAutor());
            }

        }
    }
}
