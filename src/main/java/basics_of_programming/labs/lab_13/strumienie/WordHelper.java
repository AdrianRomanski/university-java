package basics_of_programming.labs.lab_13.strumienie;

public class WordHelper {

    private String word;
    private int count;

    public WordHelper(String word) {
        this.word = word;
        this.count = 1;
    }

    public String getWord() { return word; }
    public void setWord(String word) { this.word = word; }
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
        return "WordHelper{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }
}
