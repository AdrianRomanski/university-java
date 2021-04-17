package oop.lectures.lecture_4.ex01;


import java.util.Iterator;

public class MyList<T extends Person> implements Iterable<T> {

    private Element<T> head;

    public MyList() {
        this.head = null;
    }

    public void add(T t) {
        if(head==null)
            head=new Element<>(t);
        else
            head=new Element<>(t, head);
    }

    public void show() {
        Element<T> tmp = head;
        while(tmp!=null) {
            System.out.println(tmp.getPerson().getDesc());
            tmp = tmp.getNext();
        }
    }



    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            T element;


            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
}
