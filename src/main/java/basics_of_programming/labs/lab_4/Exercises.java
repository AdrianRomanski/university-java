package basics_of_programming.labs.lab_4;

public class Exercises {

    public static void main(String[] args) {

        System.out.println("Pierwsze zadanie");
        // Palindrome
        // Write a method called isPalindrome with one int parameter called number
        // the method need to return a boolean
        // it should return true if the number is a palindrome number otherwise it should return false

        int firstNumber = 20002;

        char[] charArray = String.valueOf(firstNumber).toCharArray();

        char[] reversedArray = new char[charArray.length];
        int j = 0;
        for(int i = charArray.length - 1; i >= 0; i--) {
            reversedArray[j] = charArray[i];
            j++;
            for(char c: reversedArray) {
                System.out.print(c +", ");
            }
            for(char c: charArray) {
                System.out.print(c +", ");
            }
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();
        for(char c: reversedArray) {
            sb.append(c);
        }
        int reversedInt  = Integer.parseInt(sb.toString());

        System.out.println(reversedInt);
        System.out.println(reversedInt == firstNumber);


        System.out.println("Zadanie Drugie");
        // Write a method named sumFirstAndLastDigit with one parameter of type int called number

        // The method needs to find the first and the last digit of the parameter
        // number passed to the method using a loop and return the sum of the first and the last digit of that number

        int number = 1003213;
        // powinno wyjsc 4

        int firstDigit = 0;
        char[] chars = String.valueOf(number).toCharArray();

        int lastDigit = number % 10;

        for(int i = 0; i < chars.length; i++) {
            if(number == 10) {
                firstDigit = 1;
            }
            else if(number < 10) {
                firstDigit = number;
            }
            number = number / 10;
        }
        System.out.println(firstDigit + lastDigit);



        System.out.println("Zadanie 3");
        /// Write a method named getEvenDigitSum with one parameter of type int called number
        // The method should return the sum of the even digits within the number


        int number2 = 3202; // 4

        String number2String = String.valueOf(number2);

        char[] chars2 = number2String.toCharArray();

        int sum = 0;

        for(int i = 0; i < chars2.length; i++) {
            int temp = number2 % 10;
            if(temp % 2 == 0) {
                sum+=temp;
            }
            if(number2 > 10) {
                number2/=10;
            }
        }
        System.out.println(sum);


        System.out.println("Zadanie 4");
        // Write a method named hasSharedDigit with two parameters of type int
        // Each number should be within the range of 10 - 99.
        // the method should return true if there is a digit that appears in both numbers such as 2 in 12 and 23;
        // otherwise the method should return false

        int numberFirst = 15;
        int numberSecond = 51;

        int n1LD = numberFirst % 10;
        int n2LD = numberSecond % 10;

        int n1FD =numberFirst/10;
        int n2FD = numberSecond/10;

        System.out.println(n1FD == n2FD || n1FD == n2LD || n1LD == n2FD || n1LD == n2LD);
    }
}
