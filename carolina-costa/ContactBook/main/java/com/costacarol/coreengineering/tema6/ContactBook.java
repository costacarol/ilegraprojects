package com.costacarol.coreengineering.tema6;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {
    List<Contact> contactBook = new ArrayList<>();

    static int idSequence = 1;

    public boolean addContact(Contact contact) {
        if (searchContactByName(contact.getName()) == null) {
            contactBook.add(contact);
            this.createId(contact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact) {
        if (searchContactByName(contact.getName()) != null){
            contactBook.remove(contact);
            return true;
        }
        return false;
    }

    public List<Contact> listContact() {
        return contactBook;
    }

    public Contact searchContactByName(String name) {
        for (Contact search : listContact()) {
            if (search.getName().equalsIgnoreCase(name)) {
                return search;
            }
        }
       return null;
    }

    public Contact searchContactById(int id) {
        for (Contact search : listContact())
            if (search.getId() == id){
                return search;
            }
        return null;
    }

    private void createId(Contact contact){
        int id = idSequence++;
        contact.setId(id);
    }
}