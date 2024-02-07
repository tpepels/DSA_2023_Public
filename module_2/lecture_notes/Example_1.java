package module_2.lecture_notes;

import java.util.HashMap;
import java.util.Map;

public class Example_1 {
    public static void exampleUse() {
        // Declare the dictionary ADT to store the student grades.
        Map<String, Integer> grades = new HashMap<String, Integer>();

        // Add the student grades to the dictionary.
        grades.put("Alice", 87);
        grades.put("Bob", 72);
        grades.put("Charlie", 95);
        grades.put("Dave", 65);
        grades.put("Eve", 100);

        // Calculate the average grade for the class.
        int sum = 0;
        for (String name : grades.keySet()) { // This is to demonstrate the get function, you can also iterate over het
                                              // entrySet
            sum += grades.get(name);
        }

        double average = (double) sum / grades.size();

        // Print the average grade.
        System.out.println("The average grade is " + average);

        // Find the highest and lowest grades.
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        for (String name : grades.keySet()) { // This is to demonstrate the get function, you can also iterate over het
                                              // entrySet
            int grade = grades.get(name);
            if (grade > highest) {
                highest = grade;
            }
            if (grade < lowest) {
                lowest = grade;
            }
        }

        // Print the highest and lowest grades.
        System.out.println("The highest grade is " + highest);
        System.out.println("The lowest grade is " + lowest);

    }
}
