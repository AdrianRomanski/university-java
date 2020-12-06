package basics_of_programming.labs.lab_8;

public class MethodCurrier {


    public  void setValue(int number) {
        System.out.println("setValue with int=" + number);
    }
    public  void setValue(float number) {
        System.out.println("setValue with float=" + number);
    }

    public  void setValue(Number number) {
        System.out.println("setValue with number=" + number.getValue());
    }


}
