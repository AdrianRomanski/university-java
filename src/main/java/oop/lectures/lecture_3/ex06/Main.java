package oop.lectures.lecture_3.ex06;

import oop.lectures.lecture_3.ex04.Student;

import java.util.Arrays;
import java.util.Comparator;

public class Main {


    public static void main(String[] args) {
        Student[] arr = {
                new Student("Philipa", 67),
                new Student("Hugh", 535),
                new Student("Sylvia", 2),
                new Student("Sylvia", 1),
        };

        System.out.println(
                Arrays.toString(arr)
        );
        Arrays.sort(arr, Comparator.comparing(Student::getName)
                    .thenComparing(Student::getId));

        System.out.println(
                Arrays.toString(arr)
        );
    }
}
