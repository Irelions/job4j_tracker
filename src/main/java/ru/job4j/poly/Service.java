package ru.job4j.poly;

public class Service {
    private DbStore store;

    public Service(DbStore store) {
        this.store = store;
    }

    public void extract() {
        store.save("Evgeniy Ivanov");
    }

    public static void main(String[] args) {
        Store store = new DbStore();
        /*DbStore store = new FileStore();
        Service service = new Service(store);
        service.extract();*/

    }
}
