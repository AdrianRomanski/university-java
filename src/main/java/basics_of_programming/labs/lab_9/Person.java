package basics_of_programming.labs.lab_9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private final String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        if(birthYear > 1900) {
            this.birthYear = birthYear;
        } else {
            System.out.println("You cant be as old " + name + "! Birth date is initialized to default");
            this.birthYear = 1990;
        }
    }

    public Person(String name) { this(name, 1990); }

    public String getName() {
        return name;
    }

    public int getAge() { return 2020 - birthYear; }

    static Person getOlder(Person first, Person second) {
        return first.getAge() > second.getAge() ? first : second;
    }

    static Person getOldest(Person[] people) {
        int maxAge = 0;
        int index = 0;
        for(int i = 0; i <people.length; i++) {
            if(people[i].getAge() > maxAge) {
                maxAge=people[i].getAge();
                index=i;
            }
        }
        return people[index];
    }

    static List<Person> sortByAgeWithStreams(Person[] people) {
        return Arrays.stream(people)
                .sorted(Comparator
                .comparing(Person::getAge))
                .collect(Collectors.toList());
    }

    static List<Person> sortByAgeAndNameWithStreams(Person[] people) {
        return Arrays.stream(people)
                .sorted(Comparator
                .comparing(Person::getAge).thenComparing(Person::getName))
                .collect(Collectors.toList());
    }

    static void sortByComparing(Person[] people) {
        for(int i = 0; i < people.length; i++) {
            for(int j = 0; j < people.length; j++) {
                if(people[i].getAge() < people[j].getAge()) {
                    Person temp = people[i];
                    people[i] = people[j];
                    people[j] = temp;
                }
            }
        }
    }
}
