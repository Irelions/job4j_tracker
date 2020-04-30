package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index != value.length; index++) {
            if (value[index] != null) {
                if (value[index].equals(key)) {
                rsl = index;
                break;
                }
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Item is not found");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        // if contains throw ElementAbuseException
        return true;
    }

    public static void main(String[] args) {
        try {
            String[] name = {"Igor", null, "Vasia"};
            System.out.println(indexOf(name, "Anna"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
