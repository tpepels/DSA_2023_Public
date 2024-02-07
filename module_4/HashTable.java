package module_4;

public class HashTable {

    /**
     * This class represents the entries we'll store in our hashmap
     */
    public static class HashEntry {
        String key;
        int value;
        // Linked list of same hash entries.
        HashEntry next;

        public HashEntry(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }

    private static int INITIAL_SIZE = 16;
    private HashEntry[] entries = new HashEntry[INITIAL_SIZE];

    public void put(String key, int value) {
        // * The getHash method turns our string into a number
        int hash = getHash(key);

        final HashEntry hashEntry = new HashEntry(key, value);

        if (entries[hash] == null) {
            entries[hash] = hashEntry;
        }
        // If there is already an entry at current hash
        // position, add entry to the
        // * linked list *
        else {
            HashEntry temp = entries[hash];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = hashEntry;
        }
    }

    /**
     * Returns 'null' if the element is not found.
     */
    public int get(String key) {
        int hash = getHash(key);
        if (entries[hash] != null) {
            HashEntry temp = entries[hash];

            // Check the entry linked list for march
            // for the given 'key'
            while (!temp.key.equals(key) && temp.next != null) {
                temp = temp.next;
            }
            return temp.value;
        }

        return -1;
    }

    private int getHash(String key) {
        // piggy backing on java string hashcode implementation.
        return Math.abs(key.hashCode() % INITIAL_SIZE);
    }

    @Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : entries) {
            if (entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while (temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        String[] randomWords = {
                "fragrant",
                "bow",
                "stroll",
                "harmony",
                "survival",
                "bloody",
                "chop",
                "conglomerate",
                "produce",
                "truth",
                "camera",
                "feast",
                "joy",
                "graze",
                "retire",
                "determine",
                "projection",
                "general",
                "spot",
                "pool",
                "call",
                "charter",
                "kneel",
                "climate",
                "relate",
                "straighten",
                "distort",
                "horizon",
                "flu",
                "hair" };
        // Put some key values.
        for (int i = 0; i < randomWords.length; i++) {
            hashTable.put(randomWords[i], randomWords[i].length());
        }

        // Print the HashTable
        System.out.println(hashTable.toString());
        System.out.println("\nValue for key(produce) : " + hashTable.get("produce"));
    }

}
