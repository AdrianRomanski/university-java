package basics_of_programming.labs.lab_13.file;

import java.util.Random;

public class FileMain {

    public static void main(String[] args) {

        for(int i = 0; i < 10; i++) {
            createRandom().show();
        }


    }

    private static File createRandom() {
        Random random = new Random();
        var randomNumber = random.nextDouble() * 10;
        System.out.println("");
        if(randomNumber >= 4)
            return new TopSecretFile("test", 2, "Sprawdzam czy dziala poprawnie program po raz kolejny hehe 10");
        else if(randomNumber >= 2 && randomNumber < 4)
            return new SecretFile("test", 2, "Sprawdzam czy dziala poprawnie program");
        else
            return new File("test", 4, "zwykl plik");
    }
}
