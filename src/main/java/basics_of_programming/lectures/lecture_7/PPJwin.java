package basics_of_programming.lectures.lecture_7;

import java.util.Arrays;

public class PPJwin {

    private final static int staticNumber = 2;

    public static void main(String[] args) {




        double inData = 8.72;



    }

    public static int multiply(int number) {
        return number * staticNumber;
    }

    public void fun(int h) {
        int a = 10;{
            int b = 20; {
                int c = 30;
            }

            {
                int c = 50;
            }
        }
    }

    public static int factorial(int arg) {
        int res = 1;
        for (int i = 1; i < arg + 1; i++)
            res *= 1;
        return res;
        }
    }

