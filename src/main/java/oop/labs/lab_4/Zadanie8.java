package oop.labs.lab_4;

public class Zadanie8 {

    public static void main(String[] args) {

        IterNap napis = new IterNap("prOgrAmoWanIe ObiEktOwe i Gui");

        Iterator<Character> iterator = napis.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        napis.ustawPoczatek(2);
        napis.ustawKrok(3);

        iterator = napis.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        napis.ustawPoczatek(2);
        iterator = napis.iterator();

        while (iterator.hasNext()) {
            System.out.print(Character.toLowerCase(iterator.next()) + " ");
        }
    }


interface Iterable<T> {
    Iterator<T> iterator();
}

interface Iterator<E> {
    boolean hasNext();
    E next();
}

static class IterNap implements Iterable<Character> {
    private final String input;
    private int index;
    private int step;

    public IterNap(String input) {
        this.input = input;
        step = 1;
    }

    public void ustawPoczatek(int start) {
        index = start;
    }

    public void ustawKrok(int newStep) {
        step = newStep;
    }

    @Override
    public Iterator<Character> iterator() {

        return new Iterator<>() {

            public boolean hasNext() {
                return input.length() >= index + step;
            }

            public Character next() {
                if (hasNext()) {
                    char c = input.charAt(index);
                    index += step;
                    return c;
                } else return null;
            }
        };
    }
    }
}



