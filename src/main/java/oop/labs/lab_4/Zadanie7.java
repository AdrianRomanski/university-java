package oop.labs.lab_4;

import java.util.*;
import java.util.stream.Collectors;

public class Zadanie7 {


    public static void main(String[] args) {

        Spiewak s1 = new Spiewak("Dietrich"){
            @Override
            String spiewaj() {
                return "AAaa";
            }
        };

        Spiewak s2 = new Spiewak("Piaf"){
            @Override
            String spiewaj() {
                return "BBbb";
            }
        };

        Spiewak s5 = new Spiewak("Beyonce"){
            @Override
            String spiewaj() {
                return "AAaaBBbbCCcc";
            }
        };

        Spiewak s3 = new Spiewak("Adele"){
            @Override
            String spiewaj() {
                return "AAaaBBbbCCcc";
            }
        };

        Spiewak s4 = new Spiewak("Beyonce"){
            @Override
            String spiewaj() {
                return "AAaaBBbbCCcc";
            }
        };

        List<Spiewak> sp = Arrays.asList(s1, s2, s3, s4, s5);


        for (Spiewak s : sp)
            System.out.println(s);

        System.out.println("\n" + Spiewak.najglosniej(sp));

        System.out.println("****************************");

        Collections.sort(sp);

        for (Spiewak s : sp)
            System.out.println(s);

        System.out.println("****************************");

        List<Spiewak> collect = sp.stream()
                .sorted(Comparator.comparing(Spiewak::getSongLength)
                        .thenComparing(Spiewak::getNazwisko)
                        .thenComparing(Spiewak::getNumerStartowy))
                .collect(Collectors.toList());


        for (Spiewak s : collect)
            System.out.println(s);


    }
}

abstract class Spiewak implements Comparable<Spiewak>{
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

    public static Spiewak najglosniej(List<Spiewak> sp) {
        return (sp).stream()
                .max(Comparator.comparingInt(s -> s.characters.size()))
                .orElseThrow(() -> new RuntimeException("Pusty set"));
    }

    abstract String spiewaj();

    @Override
    public String toString() {
        return "(" + numerStartowy+ ") " + nazwisko + ": " + spiewaj();
    }

    public int getSongLength() {
        return this.characters.size();
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getNumerStartowy() {
        return numerStartowy;
    }

    @Override
    public int compareTo(Spiewak spiewak) {
        if(!(getSongLength() == spiewak.getSongLength())) {
            return getSongLength() - spiewak.getSongLength();
        } else if(!(this.nazwisko.compareTo(spiewak.nazwisko) == 0)) {
            return this.nazwisko.compareTo(spiewak.nazwisko);
        } else {
            return this.numerStartowy - spiewak.numerStartowy;
        }
    }
}