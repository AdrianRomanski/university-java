package basics_of_programming.lectures.lecture_11;

public class PPJwin {


    public static void main(String[] args) throws Exception {

        MyList myList = new MyList();
        myList.add(10);
        myList.add(20);
        myList.insert(1, 15);
        myList.show();

        MyStack myStack = new MyStack();

        try {
            myStack.push(10);
            myStack.push(20);
            myStack.push(30);
            myStack.push(30);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }



}
