package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student studentEvgeniy = new Student();

        studentEvgeniy.setFullName("Evgeniy Ivanov Sergeevich");
        studentEvgeniy.setGroup(342422);

        System.out.println("Student: " + studentEvgeniy.getFullName() + " enrolled in group № " + studentEvgeniy.getGroup());
    }
}
