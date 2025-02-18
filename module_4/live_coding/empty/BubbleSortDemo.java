package module_4.live_coding.empty;

import java.util.Arrays;

public class BubbleSortDemo {

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {

    }

    public static void main(String[] args) {
        // Example with Integers
        Integer[] intArray = { 5, 1, 4, 2, 8 };
        bubbleSort(intArray);
        System.out.println("Sorted Integer array: " + Arrays.toString(intArray));

        // Example with Strings
        String[] stringArray = { "banana", "apple", "orange", "grape" };
        bubbleSort(stringArray);
        System.out.println("Sorted String array: " + Arrays.toString(stringArray));

        // Example with custom objects (must implement Comparable)
        Person[] people = {
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 20)
        };
        bubbleSort(people);
        System.out.println("Sorted Person array: " + Arrays.toString(people));
    }

    // Example custom class implementing Comparable
    static class Person implements Comparable<Person> {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }

        @Override
        public int compareTo(Person other) {
            // Compare by age. You could also compare by name.
            return Integer.compare(this.age, other.age);
        }
    }
}