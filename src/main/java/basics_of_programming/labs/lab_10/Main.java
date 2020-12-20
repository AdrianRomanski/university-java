package basics_of_programming.labs.lab_10;

public class Main {

    public static void main(String[] args) {

        // Zadanie 1
        Kwadrat kwadrat = new Kwadrat(6);
        System.out.println(kwadrat);

        // Zadanie 2
        Walec walec = new Walec(4, 12);
        System.out.println(walec);

        // Zadanie 3
        KulaW kulaWalec = new KulaW(walec);
        KulaW kulaKwadrat = new KulaW(kwadrat);

        // Zadanie 4
        KulaNa kulaNaWalcu = new KulaNa(walec);
        KulaNa kulaNaSzescianie = new KulaNa(kwadrat);

        // Zadanie 5
        Word word = new Word();
        word.addChar('A');
        word.addChar('d');
        word.addChar('r');
        word.addChar('i');
        word.addChar('a');
        word.addChar('n');

        word.show();
        System.out.print(" Dlugosc Slowa jest rowna " + word.length());

        // Zadanie 6
        System.out.println();
        Pomegranate pomegranate = new Pomegranate("Pomegranate", 450);
        System.out.println(pomegranate);

    }
}
