package basics_of_programming.lectures.lecture_5;

import java.util.Scanner;

public class PPJ5 {

    public static void main(String[] args) {



        int wrt = 1;
        // problem 1
        int val1 = 1;
        int val2 = 2;
        int val3 = 3;

        int val23456 = 1;

        // statyczne tablice maja ustalona wielkosc przed uruchomieniem programu

        // dynamiczne - na zadanym stosie(fixed stac-dynamic array)

        // dynamiczne na zadanej stercie(fixed head-dynamic array)

        // dynamiczne na stercie(heap-dynamic array)

        // tablica jest zmienna skladajaca sie z zestawau elementow kazdy element
        // jest zmienna typu prostego lub odnosnikowego - wszystkie elementu tablicy beda tego samego typu
        // liczba elementow nie moze byc wieksza od najwiekszej liczby typu int
        // indeks jest nieujemna liczba, poczynajac od numeru 0

        int[] numbers; // nie tworzy tablicy - tworzy odnosnik do dowolnej 1 wymiarowej tablicy o
                        // blizej nieokreslonej licczbie elementow typu int


        int[] arr1 = new int[5];

        int[] arr2;
        arr2 = arr1;


        int[] arr3 = new int[5];


        int[] vec = {10,20,30};

        System.out.println(vec.length);

        String[] arrWords = {"Ala", "ma", "kota", "!"};
        System.out.println(arrWords.length);


//
        int[] arrFill = new int[10];
        System.out.println(arrFill[0]);

        for(int i = 0; i < arrFill.length; i++) {
            arrFill[i] = (int)(Math.random() * 100);
            System.out.print(arrFill[i]+ ", ");
        }

        System.out.println();

        for(int i = 0; i < arrFill.length; i++) {
            if(arrFill[i] > 30) {
                System.out.print(arrFill[i] + ", ");
            }
        }
        System.out.println();


        Scanner scanner = new Scanner(System.in);


        double[] dynArr = new double[3];
        int indexDynArr = 0;
        double tmp;
        while((tmp = scanner.nextDouble()) != 0) {
            if(indexDynArr >= dynArr.length) {
                double[] tmpArr = new double[dynArr.length*2];
                System.arraycopy(dynArr, 0, tmpArr, 0, dynArr.length);
                dynArr = tmpArr;
            }
            dynArr[indexDynArr++] = tmp;

            for(Double d: dynArr) {
                System.out.println(d);
            }
            System.out.println();
        }


    }


}
