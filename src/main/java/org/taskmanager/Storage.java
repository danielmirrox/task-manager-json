package org.taskmanager;

import java.io.FileWriter;
import java.io.FileReader;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

public class Storage {
    private static final String FILE_NAME = "tasks.json";
    private static final Gson gson = new Gson();

    public static void saveTasks(List<Task> tasks) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(tasks, writer);
        } catch (Exception e) {
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
    }

    public static List<Task> loadTasks() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            return gson.fromJson(reader, new TypeToken<List<Task>>() {}.getType());
        } catch (Exception e) {
            return new java.util.ArrayList<>();
        }
    }
}