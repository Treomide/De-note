package com.dailyreport;

class Book {
    private String title;
    private int totalPages;
    private int pagesRead;

    public Book(String title, int totalPages) {
        this.title = title;
        this.totalPages = totalPages;
        this.pagesRead = 0;
    }

    public void updateProgress(int pagesRead) {
        this.pagesRead = Math.min(pagesRead, totalPages);
    }

    @Override
    public String toString() {
        return title + " - Progress: " + pagesRead + "/" + totalPages + " pages";
    }
}
