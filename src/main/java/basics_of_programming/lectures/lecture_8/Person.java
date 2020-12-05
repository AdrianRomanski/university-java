package basics_of_programming.lectures.lecture_8;

public class Person {

    private String name;
    protected String family;

    public Person() {
        System.out.println("const: Person()");
    }

    public Person(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public void show() {
        System.out.println(this.name + " " + this.family);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
