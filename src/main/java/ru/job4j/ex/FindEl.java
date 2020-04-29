package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index != value.length; index++) {
            if (value[index] == null) {
                throw new ElementNotFoundException("Item is empty");
            } else {
                if (value[index].equals(key)) {
                    rsl = index;
                }
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            String[] name = {"Igor", null, "Vasia"};
            System.out.println(indexOf(name, "Vasia"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}