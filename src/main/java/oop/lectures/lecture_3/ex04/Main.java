package oop.lectures.lecture_3.ex04;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Student[] arr = {
                new Student("Sylvia", 2),
                new Student("Philipa", 67),
                new Student("Hugh", 535)
        };

        StudentSelector.filter(arr, new MyStudCrit());


        System.out.println(Arrays.toString(
                StudentSelector.filter(arr, new MyStudCrit())
        ));

        System.out.println(Arrays.toString(
                StudentSelector.filter(arr, student -> student.getId() > 10)
        ));


        System.out.println(Arrays.toString(
                StudentSelector.filter(arr, (s1) -> s1.getId() > 10
                )
            )
        );
    }
}

class MyStudCrit implements StudentSelector{

    @Override
    public boolean crit(Student student) {
        return student.getId() < 500;
    }
}
