package basics_of_programming.lectures.lecture_8;

public class PrzykladoweKolokwium {

    public static void main(String[] args) {

    }



    public static boolean mojaMetoda(char[] dane, char[] poszukiwane) {
        boolean flag = false;
        int count = 0;
        while (!flag) {
            for (char daneChar : dane) {
                for (char poszukiwaneChar : poszukiwane) {
                    if (poszukiwaneChar == daneChar) {
                        count++;
                        if(count == 3) {
                            flag = true;
                        }
                    }
                }
            }
        }
       return flag;
    }

}
