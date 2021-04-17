package oop.lectures.lecture_4.ex01;

public class Element<T extends Person> {

    private T person;
    private Element<T> next;

    public Element(T person) {
        this.person = person;
        this.next = null;
    }

    public Element(T person, Element<T> next) {
        this.person = person;
        this.next = next;
    }

    public T getPerson() {
        return person;
    }

    public Element<T> getNext() {
        return next;
    }
}
