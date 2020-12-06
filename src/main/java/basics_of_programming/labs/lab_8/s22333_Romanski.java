package basics_of_programming.labs.lab_8;

public class s22333_Romanski{

    public static void main(String[] args) {

        MethodCurrier methodCurrier = new MethodCurrier();
        methodCurrier.setValue(1);
        methodCurrier.setValue(1.2f);
        methodCurrier.setValue('a');
        methodCurrier.setValue(0b0001);

        // jest podejmowana na bazie tego ktora wartosc primitiwyna jest najblizej wartosci w metodzie w celu konwersji
        // jesli uzylbym double zostalaby wywolana metoda z floatem itp
        // implicit conversion


        //2
        Number number = new Number();
        number.setValue(12);

        // 3
        Osoba osoba = new Osoba();
        osoba.imie = "Adrian";
        osoba.nazwisko = "Romanski";
        osoba.rokUrodzenia = 1992;


        Osoba osoba1 = new Osoba("Adrian2", "Romanski2", 1992);

        osoba.show();

        Cplx cplx = new Cplx(2,4); // 6
        Cplx secondCplx = new Cplx(2, 3); // 5

        cplx.add(secondCplx);
        cplx.show();

        cplx.sub(secondCplx);
        cplx.show();

        cplx.mul(secondCplx);
        cplx.show();

        cplx.inc();
        cplx.show();



    }


}
