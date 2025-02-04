package module_2;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // This clears the console (on most systems)
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("");
        System.out.println("");
        // Creating a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Adding key-value pairs to the HashMap
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 35);

        // Displaying the entire map
        System.out.println("Initial map: " + map);
        System.out.println("Size of the map: " + map.size());
        System.out.println("");

        // Checking if a key exists in the map
        String keyToCheck = "Alice";
        if (map.containsKey(keyToCheck)) {
            System.out.println(keyToCheck + " is in the map and has age " + map.get(keyToCheck));
        }
        System.out.println("");

        // Iterating over entries of the map
        System.out.println("Iterating over the map:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " => " + value);
        }
        System.out.println("");

        // Removing an entry by key
        String keyToRemove = "Charlie";
        if (map.containsKey(keyToRemove)) {
            Integer removedValue = map.remove(keyToRemove);
            System.out.println("Removed " + keyToRemove + " with value " + removedValue);
        }

        // Displaying the map after removal
        System.out.println("Map after removal of " + keyToRemove + ": " + map);
        System.out.println("");
    }
}
