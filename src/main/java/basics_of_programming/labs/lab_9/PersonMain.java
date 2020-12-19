package basics_of_programming.labs.lab_9;

import java.util.List;

public class PersonMain {

    public static void main(String[] args) {

        Person person = new Person("Adrian", 1992);
        Person person1 = new Person("Filip", 1989);
        Person person2 = new Person("Dominik", 1954);
        Person person3 = new Person("Kinga", 2004);
        Person person4 = new Person("Bartek", 1899);
        Person person5 = new Person("Asia", 1992);
        Person person6 = new Person("Wojtek");

        Person[] people = {person, person1, person2, person3, person4, person5, person6};

        System.out.println("Name and Age of people:");
        for(Person p: people) {
            System.out.println(p.getName() + " " + p.getAge());
        }

        System.out.println("Oldest Person");
        Person oldest = Person.getOldest(people);
        System.out.println(oldest.getName() + " " + oldest.getAge());

        System.out.println("Get Older");
        System.out.println("Comparing " + person.getAge() + " and " + person1.getAge());
        System.out.println("Result = " + Person.getOlder(person, person1).getAge());

        System.out.println("Sorting on age with streams");
        List<Person> listPeople = Person.sortByAgeWithStreams(people);
        for(Person p: listPeople) {
            System.out.println(p.getName() + " " + p.getAge());
        }

        System.out.println("Sorting on age without streams");
        Person.sortByComparing(people);
        for(Person p: people) {
            System.out.println(p.getName() + " " + p.getAge());
        }

        System.out.println("Sorting on age and names with streams");
        List<Person> listPeopleNameAge = Person.sortByAgeAndNameWithStreams(people);
        for(Person p: listPeopleNameAge) {
            System.out.println(p.getName() + " " + p.getAge());
        }
    }
}
