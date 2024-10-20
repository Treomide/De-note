package com.dailyreport;

class Course {
private String name;
private int totalStudyTime; // in minutes

public Course(String name) {
    this.name = name;
    this.totalStudyTime = 0;
}

public void addStudySession(int duration) {
    totalStudyTime += duration;
}

@Override
public String toString() {
    return name + " - Total study time: " + totalStudyTime + " minutes";
}
}