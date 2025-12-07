/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jminiapp.examples.agenda;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ALEJANDRO ROSADO
 */

public class ContactRepository {

    private List<Contact> contacts;
    private List<ContactObserver> observers;
    private ContactValidator validator; // Strategy

    public ContactRepository() {
        this.contacts = new ArrayList<>();
        this.observers = new ArrayList<>();
        // Default Strategy (Validation rule)
        this.validator = contact -> !contact.getName().isEmpty();
    }

    public void setValidator(ContactValidator validator) {
        this.validator = validator;
    }

    public void loadData(List<Object> rawData) {
        if (rawData != null) {
            for (Object obj : rawData) {
                if (obj instanceof Contact) {
                    contacts.add((Contact) obj);
                }
            }
        }
    }

    public List<Contact> getAll() {
        return new ArrayList<>(contacts);
    }
    public boolean add(Contact contact) {
        if (validator.isValid(contact)) {
            contacts.add(contact);
            notifyObservers(contact);
            return true;
        }
        return false;
    }

    public void addObserver(ContactObserver observer) {
        this.observers.add(observer);
    }

    private void notifyObservers(Contact contact) {
        for (ContactObserver observer : observers) {
            observer.onContactAdded(contact);
        }
    }
}
