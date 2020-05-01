package ru.job4j.ex;

import javax.swing.text.TableView;

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
        for (int index = 0; index != abuses.length; index++) {
            if (abuses[index].equals(value)) {
                throw new ElementAbuseException("Item is in the forbidden list");
            }
        }
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
            String[] value = {"Igor", null, "Anna"};
            String key = "Anna";
            String[] abuses = {"Anna"};

            process(value, key, abuses);
    }
}
