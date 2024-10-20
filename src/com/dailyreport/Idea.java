package com.dailyreport;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Idea {
    private String description;
    private int rating;

    public Idea(String description) {
        this.description = description;
        this.rating = 0;
    }

    public void setRating(int rating) {
        this.rating = Math.max(1, Math.min(5, rating));
    }

    @Override
    public String toString() {
        return description + (rating > 0 ? " - Rating: " + rating + "/5" : " (Not rated)");
    }
}