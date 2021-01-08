package basics_of_programming.lectures.lecture_11;

public class MyStack {

    int[] arr;
    final int SIZE = 3;
    int fill;

    public MyStack() {
        this.arr = new int[SIZE];
        fill = 0;
    }

    public void push(int val) throws Exception {
        if(fill < SIZE) {
            arr[fill++] = val;
        } else {
            throw new Exception("Stack is full");
        }

    }

    public int pop() {
        return arr[--fill];
    }

}
