package basics_of_programming.labs.lab_12.rakieta;

public class RakietaMain {

    public static void main(String[] args) {


        Rakieta rakieta = new Rakieta("Wielka duza rakieta");
        rakieta.zatankuj();
        rakieta.zatankuj();
        rakieta.zatankuj();
        rakieta.zatankuj();

        try {
            rakieta.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}
