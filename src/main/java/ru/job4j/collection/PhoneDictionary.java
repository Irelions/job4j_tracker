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

        for (int i = 0; i < persons.size(); i++) {
            String tempString = persons.get(i).getName() + " "
                    + persons.get(i).getSurname() + " "
                    + persons.get(i).getPhone() + " "
                    + persons.get(i).getAddress();
            tempString = tempString.toLowerCase();
            if (tempString.contains(key)) {
                result.add(persons.get(i));
            }
        }
        return result;
    }
}
