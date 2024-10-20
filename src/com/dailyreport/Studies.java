package com.dailyreport;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
class Studies {
    private List<Course> courses;

    public Studies() {
        courses = new ArrayList<>();
    }

    public void manage() {
        Scanner scanner = new Scanner(System.in);
        boolean managing = true;

        while (managing) {
            System.out.println("\nStudies Menu:");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Add Study Session");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    viewCourses();
                    break;
                case 3:
                    addStudySession();
                    break;
                case 4:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        courses.add(new Course(name));
        System.out.println("Course added successfully.");
    }

    private void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses added yet.");
        } else {
            System.out.println("\nCourses:");
            for (int i = 0; i < courses.size(); i++) {
                System.out.println((i + 1) + ". " + courses.get(i));
            }
        }
    }

    private void addStudySession() {
        viewCourses();
        if (!courses.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of the course: ");
            int courseNumber = scanner.nextInt();
            if (courseNumber > 0 && courseNumber <= courses.size()) {
                System.out.print("Enter study duration (in minutes): ");
                int duration = scanner.nextInt();
                courses.get(courseNumber - 1).addStudySession(duration);
                System.out.println("Study session added.");
            } else {
                System.out.println("Invalid course number.");
            }
        }
    }
}
