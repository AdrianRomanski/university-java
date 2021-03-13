package oop.lectures.lecture_2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("Sylvia", 36, "s0678");
        Student s2 = new Student("Philipa", 48, "s0002");

        Student[] arr = {
                s2,
                s1
        };

//        for(Student s : arr)
//            System.out.println(s.getDesc());

        MyList myList = new MyList();
        myList.add(s1);
        myList.add(s2);
//        myList.show();


        Lecturer l1 = new Lecturer("tomaszew", 30, new String[]{"PPJ", "GUI"});

        myList.add(l1);

        Person[] arr2 = {
                s1,
                s2,
                l1
        };

        MyList<Person> myListG = new MyList<>();
        myListG.add(s1);
        myListG.add(l1);

        myListG.show();


        System.out.println("============");

        for(Student s : arr) {
            System.out.println(s.getDesc());
        }

        Arrays.sort(arr);

        for(Student s: arr) {
            System.out.println(s.getDesc());
        }

    }





}
