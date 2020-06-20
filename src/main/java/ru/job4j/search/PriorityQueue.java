package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        if (tasks.isEmpty()) {
            this.tasks.add(index, task);
        } else if (tasks.getLast().getPriority() < task.getPriority()) {
            tasks.addLast(task);
        } else {
            for (Task element : tasks) {
                if (element.getPriority() < task.getPriority()) {
                    index++;
                } else {
                    this.tasks.add(index, task);
                    break;
                }
            }
        }
    }

    public Task take() {
        return tasks.poll();
    }
}
