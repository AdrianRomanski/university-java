package basics_of_programming.lectures.lecture_4;

public class PPJWin {

    public static void main(String[] args) {

        double average = 0.0;

        double sum = 5000;
        int count = 0;

                    // if            // else
        average = (count == 0) ? 0 : sum / count;

        if(count == 0) {
            average = 0;
        } else {
            average = sum / count;
        }

        System.out.println("average: " + average);

        boolean czyPada = true;

        int val = czyPada ? 1 : 2;

        System.out.println(val);

        if(val > -10)
            System.out.println("A");

        if(val < 10)
            System.out.println("B");

        if(val > -10 && val < 10)
            System.out.println("A i B");

        // =====================================================

        if(val < -5)
            System.out.println("B");
        else
            if(val > 10)
                System.out.println("A");
        else
            System.out.println("A i B");
        // =====================================================


        int sVal = 15;

        switch (sVal) {
            case 0:
                System.out.println("0");
                break;
            case 1:
                System.out.println("1");
                break;
            case 9:
                System.out.println(sVal);
                break;
            case 10:
                System.out.println("A");
                break;
            case 15:
                System.out.println( (char) ('A' + (sVal - 10)));
                break;
        }

        // ======================================

        final String cat = "cat";
        final String dog = "dog";


        switch (cat) {
            // na poziomie definicji musimy zagwarantowac, ze zmienna nie bedzie sie zmieniac
            // osiagamy, to uzywajac slowa "final"
            case cat:
                System.out.println("CAT");
                break;
            case dog:
                System.out.println("DOG");
                break;
            default:
                System.out.println("PARROT");
                break;
        }

        // ======================================

        // Nie konczaca sie petla
//        while(true) {
//            System.out.println("Tu");
//        }

        // ======================================

        int i = 0;

        while (i <= 10) {
            System.out.println("while" + i);
            i++;
        }
        System.out.println("i: " + i);

        int j = 0;

        do {
            System.out.println("do:" + j);
            j++;
        } while(j <= 10);
        System.out.println("j: " + j);

        // =====================

        i = 0;

        while (i > 10) {
            System.out.println("while" + i);
            i++;
        }
        System.out.println("i: " + i);

        j = 0;

        do {
            System.out.println("do:" + j);
            j++;
        } while(j > 10);
        System.out.println("j: " + j);


        // ======================================

        for(int k = 0; k < 10; k++) {
            System.out.println("for: " + k);
        }

//        for( ; ; )
//            ;

        for(int k = 0; k<10; k++) {
            for(int l = 0; l < 10; l++) {
                System.out.print(k*l  +"\t");
            }
            System.out.println();
        }


        // ======================================

        sum = 0;
        for(int m=1; m<=9; m++) {
            if(m < 3) {
                sum--;
                continue;
            } else {
                if(sum > 7)
                    break;
            }
            sum = sum + 2 * m;
        }
        System.out.println(sum);
    }
}
