package basics_of_programming.lectures.lecture_11;

public class Node {

    Node next;
    int val;

    public Node(int val) {
        this.val = val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", val=" + val +
                '}';
    }
}
