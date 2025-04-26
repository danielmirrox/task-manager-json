package org.taskmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(String title) {
        tasks.add(new Task(title));
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public boolean markDone(String id) {
        Optional<Task> task = findById(id);
        if (task.isPresent()) {
            task.get().markDone();
            return true;
        }
        return false;
    }

    public boolean deleteTask(String id) {
        Optional<Task> task = findById(id);
        return task.map(tasks::remove).orElse(false);
    }

    private Optional<Task> findById(String id) {
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst();
    }
}