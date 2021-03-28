package oop.labs.lab_3;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Zadanie6 {

    public static void main(String[] args) {

        Spiewak s1 = new Spiewak("Dietrich"){
            @Override
            String spiewaj() {
                return "AAaa123456789";
            }
        };

        Spiewak s2 = new Spiewak("Piaf"){
            @Override
            String spiewaj() {
                return "AAaaBBbb";
            }
        };

        Spiewak s3 = new Spiewak("Adele"){
            @Override
            String spiewaj() {
                return "AAaaBBbbCCcc";
            }
        };

        Spiewak[] sp = {s1, s2, s3};

        for (Spiewak s : sp)
            System.out.println(s);

        System.out.println("\n" + Spiewak.najglosniej(sp));
    }
}

abstract class Spiewak {
    private String nazwisko;
    private static int maxNumerStartowy;
    private int numerStartowy;
    private Set<Character> characters = new HashSet<>();

    public Spiewak(String nazwisko) {
        this.nazwisko = nazwisko;
        numerStartowy = maxNumerStartowy++;
        String spiewaj = spiewaj();
        for(char c: spiewaj.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                this.characters.add(c);
            }
        }
    }

    public static Spiewak najglosniej(Spiewak[] sp) {
        return Stream.of(sp)
                .max(Comparator.comparingInt(s -> s.characters.size()))
                .orElseThrow(() -> new RuntimeException("Pusty set"));
    }

    abstract String spiewaj();

    @Override
    public String toString() {
        return "(" + numerStartowy+ ") " + nazwisko + ": " + spiewaj();
    }
}
