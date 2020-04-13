package com.mariiapasichna;

import com.mariiapasichna.models.Student;

public class Main {
    public static void main(String[] args) {
        addData();
        showData();
    }

    private static void showData() {
        DataService dataService = new DataService();
        System.out.println("Students list: " + dataService.getStudentsByGroup("Java"));
        System.out.println("Groups list: " + dataService.getGroupsByStudentName("Bill"));
        dataService.close();
    }

    private static void addData() {
        DataService dataService = new DataService();

        dataService.clear();

        dataService.addGroup("Java");
        dataService.addGroup("Python");
        dataService.addGroup("JavaScript");

        Student student1 = new Student("Alex");
        student1.addGroup(dataService.getGroup("Java"));
        student1.addGroup(dataService.getGroup("JavaScript"));
        dataService.addStudent(student1);

        Student student2 = new Student("Bill");
        student2.addGroup(dataService.getGroup("Java"));
        student2.addGroup(dataService.getGroup("Python"));
        dataService.addStudent(student2);

        Student student3 = new Student("Roy");
        student3.addGroup(dataService.getGroup("Python"));
        dataService.addStudent(student3);

        dataService.close();
    }
}