package basics_of_programming.lectures.lecture_8;

public class PPJ {

    public static void main(String[] args) {

        Tool.show();
        Double pi = Tool.PI;

        int[] tab = new int[5];

        Person person = null;
        person = new Person();
        person = new Person("Jan", "Chlebczynski");
        person.show();

        person.setName("Adrian");
        person.show();

        System.out.println(person.getName());


    }
}



