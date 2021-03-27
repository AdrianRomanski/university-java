package oop.lectures.lecture_3.ex04;

@FunctionalInterface
public interface StudentSelector {

    boolean crit(Student student);

    static Student[] filter(Student[] students, StudentSelector selector) {
        int count = 0;
        for(Student s: students) {
            if(selector.crit(s)) {
                count++;
            }
        }
        Student[] res = new Student[count];
        count = 0;
        for(Student s: students) {
            if(selector.crit(s)) {
                res[count++] = s;
            }
        }
        return res;
    }
}
