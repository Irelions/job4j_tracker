package ru.job4j.collection;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        key = key.toLowerCase();

        for (Person person: persons) {
            if (person.getName().toLowerCase().contains(key)
            || person.getSurname().toLowerCase().contains(key)
            || person.getPhone().toLowerCase().contains(key)
            || person.getAddress().toLowerCase().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
