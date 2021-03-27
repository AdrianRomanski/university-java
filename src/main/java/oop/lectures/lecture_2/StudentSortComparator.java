package oop.lectures.lecture_2;

import oop.lectures.lecture_3.ex01.StudentSortType;

import java.util.Comparator;

public class StudentSortComparator implements Comparator<Person> {


    private StudentSortType sortType;

    public StudentSortComparator(StudentSortType sortTy) {
        this.sortType = sortTy;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return switch (sortType) {
            case BYAGE -> o1.getAge() - o2.getAge();
            case BYNAME -> o1.getName().compareTo(o2.getName());
        };
    }
}
