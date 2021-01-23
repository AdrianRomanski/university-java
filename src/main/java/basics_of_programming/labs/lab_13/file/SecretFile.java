package basics_of_programming.labs.lab_13.file;

public class SecretFile extends File{

    private int count;

    public SecretFile(String name, int pages, String text) {
        super(name, pages, text);
    }

    public void show() {
       for(String s: this.getText().split(" ")) {
           count++;
           if(count % 2 == 0)
               System.out.print(s);
           else
               System.out.print("*");
       }
    }
}
