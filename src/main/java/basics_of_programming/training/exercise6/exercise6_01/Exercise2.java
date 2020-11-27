package basics_of_programming.training.exercise6.exercise6_01;

import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {

        boolean ifItsPal = exercise1();
        System.out.println(ifItsPal);

    }

    static boolean exercise1() {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] mask = {1,2,4,8,16,32,64,128};
        int[] bits = new int[8];
        for(int i = 7; i >= 0; i--) {
            int bit = mask[i] & number;
            if(bit != 0)
                bits[i]=1;
            else
                bits[i]=0;
        }
        int right = 7;
        for(int i = 0; i < 8; i++) {
            if(bits[i] != bits[right])
                return false;
            right--;
        }
        return true;
    }


    static void exercise2() {

    }


}
