package oop.lectures.lecture_4.ex01;

import java.util.Objects;

public class Student extends Person {

    private String id;

    public Student(String name, int age, String id) {
        super(name, age);
        this.id = id;
    }

    public String getDesc() {
        return "Student " + this.id;
    }


    public boolean equals(Object obj) {
        Student s = (Student) obj;
        if(this.getName().compareTo(s.getName()) == 0) {
            if(this.id == s.id) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = hash + 31 * (this.getName() == null ? 0 : this.getName().hashCode());
        return hash + (this.id == null ? 0 : this.id.hashCode());
//
//        return Objects.hash(this.getName(), this.getAge(), id);
    }
}
