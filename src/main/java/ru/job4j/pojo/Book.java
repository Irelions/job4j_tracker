package ru.job4j.pojo;

public class Book {
    private String name;
    private String autor;

    public Book(String name, String autor) {
        this.name = name;
        this.autor = autor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
