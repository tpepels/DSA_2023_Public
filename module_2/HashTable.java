package module_2;

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

    // We’ll keep track of the current capacity as an instance variable
    // instead of relying on INITIAL_SIZE being final or static.
    private int capacity = 16;
    private HashEntry[] entries = new HashEntry[capacity];

    /**
     * Inserts a key-value pair into the hashtable.
     */
    public void put(String key, int value) {
        // * The getHash method turns our string into a number
        int hash = getHash(key, capacity);

        final HashEntry hashEntry = new HashEntry(key, value);

        if (entries[hash] == null) {
            entries[hash] = hashEntry;
        } else {
            // If there is already an entry at current hash position,
            // append new entry to the end of the linked list
            HashEntry temp = entries[hash];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = hashEntry;
        }

        // Optional: call grow() based on a load factor if desired, e.g.:
        // if (currentSize / (double) capacity > 0.75) {
        // grow();
        // }
    }

    /**
     * Returns the value for the given key, or -1 if not found.
     */
    public int get(String key) {
        int hash = getHash(key, capacity);
        if (entries[hash] != null) {
            HashEntry temp = entries[hash];
            // Traverse the linked list to find matching key
            while (temp != null) {
                if (temp.key.equals(key)) {
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return -1; // Not found
    }

    /**
     * A helper method to hash a key against a given length (i.e., capacity).
     */
    private int getHash(String key, int length) {
        return Math.abs(key.hashCode() % length);
    }

    /**
     * This method grows (resizes) the hashtable by doubling its capacity
     * and re-hashing all existing entries.
     */
    public void grow() {
        int newCapacity = capacity * 2;
        HashEntry[] newEntries = new HashEntry[newCapacity];

        // Re-hash all existing entries into the new array
        for (HashEntry entry : entries) {
            HashEntry current = entry;
            while (current != null) {
                // Calculate new hash for the current entry using new capacity
                int newHash = getHash(current.key, newCapacity);

                // Create a new node to insert into newEntries
                HashEntry newEntry = new HashEntry(current.key, current.value);
                // If there’s no collision in the new table:
                if (newEntries[newHash] == null) {
                    newEntries[newHash] = newEntry;
                } else {
                    // Collisions: append to the end of the linked list
                    HashEntry temp = newEntries[newHash];
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = newEntry;
                }
                // Move to next in old linked list
                current = current.next;
            }
        }

        // Replace old entries array with the new one
        entries = newEntries;
        capacity = newCapacity;
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
                "hair"
        };

        // Put some key values.
        for (int i = 0; i < randomWords.length; i++) {
            hashTable.put(randomWords[i], randomWords[i].length());
        }

        // Print the HashTable
        System.out.println(hashTable.toString());
        System.out.println("\nValue for key(produce) : " + hashTable.get("produce"));

        // Call grow to demonstrate resizing.
        hashTable.grow();
        System.out.println("\n--- After grow() ---");
        System.out.println(hashTable.toString());
    }
}
