package org.taskmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskService service = new TaskService();
        service.getTasks().addAll(Storage.loadTasks());

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Добавить задачу\n2. Показать задачи\n3. Отметить как выполненную\n4. Удалить задачу\n5. Выйти");
            System.out.print("Выбор: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Введите задачу: ");
                    service.addTask(scanner.nextLine());
                    break;
                case "2":
                    for (Task task : service.getTasks()) {
                        System.out.println(task);
                    }
                    break;
                case "3":
                    System.out.print("Введите ID задачи: ");
                    if (!service.markDone(scanner.nextLine())) {
                        System.out.println("Задача не найдена.");
                    }
                    break;
                case "4":
                    System.out.print("Введите ID задачи: ");
                    if (!service.deleteTask(scanner.nextLine())) {
                        System.out.println("Задача не найдена.");
                    }
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("Неверный ввод.");
            }
            Storage.saveTasks(service.getTasks());
        }
        System.out.println("Выход. Все изменения сохранены.");
    }
}