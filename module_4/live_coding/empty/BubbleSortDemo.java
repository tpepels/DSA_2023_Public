package module_4.live_coding.empty;

import java.util.Arrays;

public class BubbleSortDemo {

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // swap arr[j] and arr[j+1]
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
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
            // return this.name.compareTo(other.name);
        }
    }
}