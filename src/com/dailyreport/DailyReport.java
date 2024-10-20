package com.dailyreport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DailyReport {
    private DailyTasks
            dailyTasks;
    private ReadBook readBook;
    private Studies studies;
    private Ideas ideas;
    private FocusSession focusSession;
    private Scanner scanner;

    public DailyReport() {
        dailyTasks = new DailyTasks();
        readBook = new ReadBook();
        studies = new Studies();
        ideas = new Ideas();
        focusSession = new FocusSession();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    dailyTasks.manage();
                    break;
                case 2:
                    readBook.manage();
                    break;
                case 3:
                    studies.manage();
                    break;
                case 4:
                    ideas.manage();
                    break;
                case 5:
                    focusSession.manage();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nDaily Report Menu:");
        System.out.println("1. Daily Tasks");
        System.out.println("2. Read Book");
        System.out.println("3. Studies");
        System.out.println("4. Ideas");
        System.out.println("5. Focus Session");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        DailyReport dailyReport = new DailyReport();
        dailyReport.run();
    }
}

class FocusSession {
    private List<Task> tasks;
    private int timerDuration; // in minutes

    public FocusSession() {
        tasks = new ArrayList<>();
        timerDuration = 120; // Default 2-hour session
    }

    public void manage() {
        Scanner scanner = new Scanner(System.in);
        boolean managing = true;

        while (managing) {
            System.out.println("\nFocus Session Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Start Session");
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
                    startSession();
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
            System.out.println("\nFocus Session Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private void startSession() {
        System.out.println("Starting 2-hour focus session...");
        // Simulating a timer
        try {
            Thread.sleep(5000); // Wait for 5 seconds (simulating 2 hours)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Focus session completed!");
        markTasksCompleted();
    }

    private void markTasksCompleted() {
        Scanner scanner = new Scanner(System.in);
        for (Task task : tasks) {
            System.out.print("Did you complete '" + task.getDescription() + "'? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("y")) {
                task.setCompleted(true);
            }
        }
    }
}

class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return (completed ? "[X] " : "[ ] ") + description;
    }
}