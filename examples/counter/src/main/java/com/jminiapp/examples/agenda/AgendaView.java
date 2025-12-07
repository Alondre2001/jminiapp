/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jminiapp.examples.agenda;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author ALEJANDRO ROSADO
 */



public class AgendaView {

    private final Scanner scanner;

    public AgendaView() {
        this.scanner = new Scanner(System.in);
    }

    public String showMenuAndGetOption() {
        System.out.println("\n=== PROFESSIONAL AGENDA APP ===");
        System.out.println("1. List Contacts");
        System.out.println("2. Add New Contact");
        System.out.println("3. Exit");
        System.out.print("Select an option: ");
        return scanner.nextLine();
    }

    public void showContacts(List<Contact> contacts) {
        System.out.println("\n--- Contact List ---");
        if (contacts.isEmpty()) {
            System.out.println("(No contacts found)");
        } else {
            contacts.forEach(c -> System.out.println(c.toString()));
        }
    }

    public Contact getNewContactInput() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        return new Contact(name, phone);
    }

    public void showMessage(String message) {
        System.out.println(">> " + message);
    }
}
