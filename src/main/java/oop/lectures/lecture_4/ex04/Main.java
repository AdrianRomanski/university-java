package oop.lectures.lecture_4.ex04;

import oop.lectures.lecture_4.ex01.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Student[] arr = {
                new Student("Sylvia", 24, "1"),
                new Student("Philipa", 19, "2"),
                new Student("Hugh", 42, "3")
        };


        Stream.generate(Math::random)
            .limit(10)
            .forEach(System.out::println);

        System.out.println("----------------------");

        Stream.iterate(1, elem -> elem + 2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("----------------------");

        Arrays.stream(new int[]{9,8,7})
                .forEach(System.out::println);

        System.out.println("----------------------");

        Stream.iterate(1, el -> el + 1)
                .takeWhile(element -> element < 10)
                .forEach(System.out::println);

        System.out.println("----------------------");

        Stream.iterate(1, el -> el + 1)
                .dropWhile(element -> element < 10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("----------------------");

        Stream.iterate(1, el -> el + 1)
                .takeWhile(e1 -> e1 < 10)
                .dropWhile(e2 -> e2 < 5)
                .forEach(System.out::println);


        System.out.println("----------------------");

        Stream.iterate(1, el -> el + 1)
                .takeWhile(e1 -> e1 < 10)
                .dropWhile(e2 -> e2 < 5)
                .map(n -> 2 * n + 1)
                .forEach(System.out::println);

        System.out.println("----------------------");

        List<Integer> list = Stream.iterate(1, el -> el + 1)
                .takeWhile(e1 -> e1 < 10)
                .dropWhile(e2 -> e2 < 5)
                .map(n -> 2 * n + 1)
                .collect(Collectors.toList());

        System.out.println(list);

        System.out.println("----------------------");

    }
}
