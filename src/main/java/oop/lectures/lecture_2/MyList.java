package oop.lectures.lecture_2;

public class MyList<T extends Person> {

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
            System.out.println(tmp.person.getDesc());
            tmp = tmp.next;
        }
    }

}
