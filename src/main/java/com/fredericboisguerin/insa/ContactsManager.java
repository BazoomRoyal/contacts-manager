package com.fredericboisguerin.insa;

import java.util.ArrayList;

public class ContactsManager {

    private ArrayList<Contact> ContactList;

    public ContactsManager() {
        this.ContactList = new ArrayList<Contact>();
    }

    public void addContact(String name, String email, String phoneNumber) throws InvalidContactNameException, InvalidEmailException {

        if (name == null || name == "") {
            throw new InvalidContactNameException();
        } else if (email != null && !email.contains("@")) {
            throw new InvalidEmailException();
        }
        this.ContactList.add(new Contact(name, email, phoneNumber));

    }

    public void printAllContacts() {
        for (Contact C : ContactList) {
            System.out.println(C.toString());
        }
    }

    public void searchContactByName(String name) {

        for (Contact C : ContactList) {
            if (C.name.toLowerCase().contains(name.toLowerCase())) {
                System.out.println(C.toString());
            }

        }
    }
}
