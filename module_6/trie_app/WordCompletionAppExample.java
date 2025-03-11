package trie_app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class WordCompletionAppExample {

    public static void main(String[] args) {
        ExtendedTrieExample trie = new ExtendedTrieExample();
        // This path is relative to the project root directory, you may have to change
        // it based on your project structure
        loadWordsIntoTrie(trie, "words.txt");
        // Print the number of nodes in the trie
        System.out.println("Number of nodes in the trie: " + String.format("%,d", trie.size()));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a prefix to search for completions (type 'EXIT' to quit):");
            String prefix = scanner.nextLine();
            if ("EXIT".equalsIgnoreCase(prefix)) {
                break;
            }
            if (prefix.isEmpty()) {
                System.out.println("Please enter a valid prefix.");
                continue;
            }
            if (prefix.length() < 3) {
                System.out.println("Please enter a prefix of at least 3 characters.");
                continue;
            }
            List<String> completions = trie.getWordsWithPrefix(prefix.toLowerCase());
            if (completions.isEmpty()) {
                System.out.println("No completions found for \"" + prefix + "\".");
            } else {
                System.out.println("Completions for \"" + prefix + "\":");
                completions.forEach(System.out::println);
            }
        }
        scanner.close();
    }

    private static void loadWordsIntoTrie(ExtendedTrieExample trie, String fileName) {
        int lines = 0, characters = 0;
        try {
            Scanner fileScanner = new Scanner(new File(fileName));

            while (fileScanner.hasNextLine()) {
                lines++;
                String word = fileScanner.nextLine().toLowerCase();
                word = word.replaceAll("[^a-z]", ""); // Remove non-alphabetic characters
                trie.insert(word);
                characters += word.length();
            }
            fileScanner.close();
            System.err.println("Loaded " + String.format("%,d", lines) + " words into the trie.");
            System.err.println("Total characters: " + String.format("%,d", characters));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}
