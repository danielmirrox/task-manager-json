package org.taskmanager;

import java.util.UUID;

public class Task {
    private final String id;
    private final String title;
    private boolean isDone;

    public Task(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.isDone = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return (isDone ? "[x] " : "[ ] ") + title + " (ID: " + id + ")";
    }
}