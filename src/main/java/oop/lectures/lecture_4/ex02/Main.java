package oop.lectures.lecture_4.ex02;

import oop.lectures.lecture_4.ex01.Student;

import java.util.*;

public class Main {


    public static void main(String[] args) {


        Student[] arr = {
                new Student("Sylvia", 2, "1"),
                new Student("Sylvia", 2, "1"),
                new Student("Sylvia", 2, "1")
        };

        List<Student> list = new ArrayList<>();
        list.add(arr[0]);
        list.add(arr[1]);
        list.add(arr[2]);

        List<Student> linkedList = new LinkedList<>();
        linkedList.add(arr[0]);
        linkedList.add(arr[1]);
        linkedList.add(arr[2]);

        Set<Student> set = new HashSet<>();
        set.add(arr[0]);
        set.add(arr[1]);
        set.add(arr[2]);

        Queue<Student> queue = new PriorityQueue<>();
        queue.add(arr[0]);
        queue.add(arr[1]);
        queue.add(arr[2]);



    }

}
