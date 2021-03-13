package oop.lectures.lecture_2;

import java.util.Arrays;

public class Lecturer extends Person{

    private String[] subjects;

    public Lecturer(String name, int age, String[] subjects) {
        super(name, age);
        this.subjects = subjects;
    }

    public String getDesc() {
        return "Lectures " + Arrays.toString(subjects);
    }
}
