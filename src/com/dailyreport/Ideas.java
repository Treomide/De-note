package com.dailyreport;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
class Ideas {
    private List<Idea> ideas;

    public Ideas() {
        ideas = new ArrayList<>();
    }

    public void manage() {
        Scanner scanner = new Scanner(System.in);
        boolean managing = true;

        while (managing) {
            System.out.println("\nIdeas Menu:");
            System.out.println("1. Add Idea");
            System.out.println("2. View Ideas");
            System.out.println("3. Rate Idea");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addIdea();
                    break;
                case 2:
                    viewIdeas();
                    break;
                case 3:
                    rateIdea();
                    break;
                case 4:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addIdea() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter idea description: ");
        String description = scanner.nextLine();
        ideas.add(new Idea(description));
        System.out.println("Idea added successfully.");
    }

    private void viewIdeas() {
        if (ideas.isEmpty()) {
            System.out.println("No ideas added yet.");
        } else {
            System.out.println("\nIdeas:");
            for (int i = 0; i < ideas.size(); i++) {
                System.out.println((i + 1) + ". " + ideas.get(i));
            }
        }
    }

    private void rateIdea() {
        viewIdeas();
        if (!ideas.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of the idea to rate: ");
            int ideaNumber = scanner.nextInt();
            if (ideaNumber > 0 && ideaNumber <= ideas.size()) {
                System.out.print("Enter rating (1-5): ");
                int rating = scanner.nextInt();
                ideas.get(ideaNumber - 1).setRating(rating);
                System.out.println("Idea rated successfully.");
            } else {
                System.out.println("Invalid idea number.");
            }
        }
    }
}
