package basics_of_programming.labs.lab_13.file;

public class TopSecretFile extends File{

    private int count;

    public TopSecretFile(String name, int pages, String text) {
        super(name, pages, text);
    }

    public void show() {
        for(String s: this.getText().split(" ")) {
            count++;
            if(count % 5 == 0)
                System.out.print(s);
            else
                System.out.print("*");
        }
    }
}
