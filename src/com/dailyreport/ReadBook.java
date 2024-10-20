package com.dailyreport;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
class ReadBook {
    private List<Book> books;

    public ReadBook() {
        books = new ArrayList<>();
    }

    public void manage() {
        Scanner scanner = new Scanner(System.in);
        boolean managing = true;

        while (managing) {
            System.out.println("\nRead Book Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Reading Progress");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    updateReadingProgress();
                    break;
                case 4:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter total pages: ");
        int totalPages = scanner.nextInt();
        books.add(new Book(title, totalPages));
        System.out.println("Book added successfully.");
    }

    private void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books added yet.");
        } else {
            System.out.println("\nBooks:");
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }

    private void updateReadingProgress() {
        viewBooks();
        if (!books.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of the book to update: ");
            int bookNumber = scanner.nextInt();
            if (bookNumber > 0 && bookNumber <= books.size()) {
                System.out.print("Enter pages read: ");
                int pagesRead = scanner.nextInt();
                books.get(bookNumber - 1).updateProgress(pagesRead);
                System.out.println("Reading progress updated.");
            } else {
                System.out.println("Invalid book number.");
            }
        }
    }
}
