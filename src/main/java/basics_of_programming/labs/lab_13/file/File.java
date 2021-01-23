package basics_of_programming.labs.lab_13.file;

public class File {

    private String name;
    private int pages;
    private String text;


    public File(String name, int pages, String text) {
        this.name = name;
        this.pages = pages;
        this.text = text;
    }

    public void show() {
        System.out.print("Czy masz dostep?");
    }

    public String getName() {
        return name;
    }

    public int getPages() {
        return pages;
    }

    public String getText() {
        return text;
    }
}
