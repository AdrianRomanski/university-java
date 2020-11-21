package basics_of_programming.lectures.lecture_6;

public class PPJWin {

    public static void main(String[] args) {


        int[] arr = new int[10];

        int fill = 0;

        for (int i = 0; i < 3; i++) {
            arr[i] = (i + 1) * 10;
            fill++;
        }


        System.out.print(fill + ":");
        for (int val : arr) {
            System.out.print(val + ", ");
        }

        System.out.println();

        arr[fill] = 40;
        fill++;

        System.out.print(fill + ":");
        for (int val : arr) {
            System.out.print(val + ", ");
        }

        System.out.println();
        // Dodawanie nowego elementu w srodku tablicy
        int into = 1;
        for (int i = fill; i > 2; i--) {
            arr[i] = arr[i - 1];
        }
        arr[into] = 25;
        fill++;


        System.out.print(fill + ":");
        for (int val : arr) {
            System.out.print(val + ", ");
        }
        System.out.println();

        // Usuwanie elementu ze srodka tablicy
        int delElement = 2;

        for (int i = delElement + 1; i < fill; i++) {
            arr[i - 1] = arr[i];
        }
        fill--;
        arr[fill] = 0;


        System.out.print(fill + ":");
        for (int val : arr) {
            System.out.print(val + ", ");
        }
        /////////////////////

        int[] arrDisorder = new int[20];


        for (int i = 0; i < arrDisorder.length; i++) {
            arrDisorder[i] = (int) (Math.random() * 10);
        }


        // Sortowanie przez wybieranie
        for (int j = 0; j < arrDisorder.length - 1; j++) {
            int indexMin = j;
            for (int i = indexMin + 1; i < arrDisorder.length; i++) {
                if (arrDisorder[indexMin] > arrDisorder[i]) {
                    indexMin = i;
                }
                int tmp = arrDisorder[indexMin];
                arrDisorder[indexMin] = arrDisorder[j];
                arrDisorder[j] = tmp;
            }
        }
        System.out.println();
        for (int val : arrDisorder) {
            System.out.print(val + ", ");
        }


        //
        int[][] arr2D = {{3, 2, 1}, {8, 5, 7}};

        System.out.println();

        System.out.println(arr2D[0][2]);

        System.out.println(arr2D[1][2]);

//        ================

        int[][] arr2DD = new int[4][3];

        for (int i = 0; i < arr2DD.length; i++) {
            System.out.println();
            for (int j = 0; j < arr2DD[i].length; j++) {
                System.out.print(arr2DD[i][j] + ", ");
            }
        }

        //        ================

        int[][] arr2DS = new int[4][];


        System.out.println();
        System.out.println("Tablica szarpana");
        /// Tablica szarpana
        for(int i=0; i< arr2DS.length; i++) {
            arr2DS[i] = new int[(int)(Math.random() * 6)];
        }

        for (int i = 0; i < arr2DS.length; i++) {
            System.out.println();
            for (int j = 0; j < arr2DS[i].length; j++) {
                System.out.print(arr2DS[i][j] + ", ");
            }
        }

        // Trojwymiarowa tablica

        int [][][] arr3D = new int[3][3][3];

    }
}
