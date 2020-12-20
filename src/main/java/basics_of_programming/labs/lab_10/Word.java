package basics_of_programming.labs.lab_10;

public class Word {

    private char[] chars;
    private int index;

    public Word() {
        this.chars = new char[100];
        this.index = 0;
    }

    public void addChar(char c) {
        this.chars[index++]=c;
    }

    public int length() {
        return index;
    }

    public void show() {
        for(int i = 0; i < index; i++) {
            System.out.print(this.chars[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(char c: this.chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
