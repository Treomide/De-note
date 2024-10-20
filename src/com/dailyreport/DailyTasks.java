package com.dailyreport;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class DailyTasks {
    private List<Task> tasks;

    public DailyTasks() {
        tasks = new ArrayList<>();
    }

    public void manage() {
        Scanner scanner = new Scanner(System.in);
        boolean managing = true;

        while (managing) {
            System.out.println("\nDaily Tasks Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskCompleted();
                    break;
                case 4:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added successfully.");
    }

    private void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks added yet.");
        } else {
            System.out.println("\nDaily Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private void markTaskCompleted() {
        viewTasks();
        if (!tasks.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of the task to mark as completed: ");
            int taskNumber = scanner.nextInt();
            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                tasks.get(taskNumber - 1).setCompleted(true);
                System.out.println("Task marked as completed.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}

