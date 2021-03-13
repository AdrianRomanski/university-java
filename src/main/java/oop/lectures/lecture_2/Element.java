package oop.lectures.lecture_2;

public class Element<T extends Person> {

    protected T person;
    protected Element<T> next;

    public Element(T person) {
        this.person = person;
        this.next = null;
    }

    public Element(T person, Element<T> next) {
        this.person = person;
        this.next = next;
    }
}
