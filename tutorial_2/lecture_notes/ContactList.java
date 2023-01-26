package tutorial_2.lecture_notes;

import java.util.Map;
import java.util.HashMap;

public class ContactList {
    private Map<String, String> contacts;

    public ContactList() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
    }

    public String getPhoneNumber(String name) {
        return contacts.get(name);
    }

    public void removeContact(String name) {
        contacts.remove(name);
    }
}
