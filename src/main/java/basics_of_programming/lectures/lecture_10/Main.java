package basics_of_programming.lectures.lecture_10;

public class Main {

    public static void main(String[] args) {

        try {
            fun();
        } catch (MyException e) {
            e.printStackTrace();
        }


        System.out.println("ss");
    }

    public static void fun() throws MyException {
        throw new MyException();
    }
}
