package com.epam.kseniya_samokhina.java.lesson3.task1;

import com.epam.kseniya_samokhina.java.lesson3.task1.Education.Course;
import com.epam.kseniya_samokhina.java.lesson3.task1.Education.Report;
import com.epam.kseniya_samokhina.java.lesson3.task1.Education.Student;
import javafx.util.Pair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws ParseException {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Student Student1 = new Student("Ivan", "Ivanov", "J2EE Developer", simpleDateFormat.parse("1-04-2018"));
        Student Student2 = new Student("Petr", "Petrov", "Java Developer", simpleDateFormat.parse("2-05-2018"));

        Course course1 = new Course("Технология Java Servlets", 16);
        Course course2 = new Course("Struts Framework", 24);
        Course course3 = new Course("Обзор технологий Java", 8);
        Course course4 = new Course("Библиотека JFC/Swing", 16);
        Course course5 = new Course("Технология JDBC", 16);

        ArrayList<Course> firstStudentCourse = new ArrayList<>();
        firstStudentCourse.add(course1);
        firstStudentCourse.add(course2);

        ArrayList<Course> secondStudentCourse = new ArrayList<>();
        secondStudentCourse.add(course3);
        secondStudentCourse.add(course4);
        secondStudentCourse.add(course5);

        ArrayList<Pair<Student, ArrayList<Course>>> StudentData = new ArrayList<>();
        StudentData.add(new Pair(Student1, firstStudentCourse));
        StudentData.add(new Pair(Student2, secondStudentCourse));

        System.out.println("Short report - 1");
        System.out.println("Detailed report - 2");
        int reportSelection = scanner.nextInt();

        for (Pair<Student, ArrayList<Course>> studentArrayList : StudentData) {
            System.out.println(studentArrayList.getKey().toString());
            Report report = new Report();
            report.getReport(reportSelection, studentArrayList.getKey().getStartDate(), studentArrayList.getValue());
        }
    }
}
