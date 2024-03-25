import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class WordCompletionApp {

    public static void main(String[] args) {
        ExtendedTrie trie = new ExtendedTrie();
        loadWordsIntoTrie(trie, "module_6/words.txt");

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

    private static void loadWordsIntoTrie(ExtendedTrie trie, String fileName) {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine()) {
                String word = fileScanner.nextLine().toLowerCase();
                word = word.replaceAll("[^a-z]", ""); // Remove non-alphabetic characters
                trie.insert(word);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}
