package oop.lectures.lecture_2;

import java.util.Arrays;

public class Student extends Person {

    private String id;

    public Student(String name, int age, String id) {
        super(name, age);
        this.id = id;
    }

    public String getDesc() {
        return "Student " + this.id;
    }

}