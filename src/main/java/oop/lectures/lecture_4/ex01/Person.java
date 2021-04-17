package oop.lectures.lecture_4.ex01;

public class Person implements Comparable<Person>{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getDesc() {
        return this.name + "  " + this.age;
    }


    public int compareTo(Person person) {
        return this.age - person.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
