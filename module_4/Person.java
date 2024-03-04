package module_4;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    // Constructor, getters, and setters

    @Override
    public int compareTo(Person anotherPerson) {
        return this.age - anotherPerson.age;
    }

    // Properties
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// Alternatively, you can use a separate class to implement the Comparator
// interface and pass it to the sort method.
class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}

class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
