package oop.lectures.lecture_4.ex03;

import oop.lectures.lecture_4.ex01.Student;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student("Jan", 15, "1");
        Student s2 = new Student("Jan", 15, "1");

        System.out.println(s1.equals(s2));

    }
}
