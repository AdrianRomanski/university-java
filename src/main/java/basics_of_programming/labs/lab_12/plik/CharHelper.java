package basics_of_programming.labs.lab_12.plik;

public class CharHelper {

    private char character;
    private int count;

    public CharHelper() {
        this.count = 1;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public void incrementCount() {
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CharHelper{" +
                "character=" + character +
                ", count=" + count +
                '}';
    }
}
