/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jminiapp.examples.agenda;
import com.jminiapp.core.api.JMiniApp;
import com.jminiapp.core.api.JMiniAppConfig;
import com.jminiapp.core.engine.JMiniAppRunner;
import java.util.ArrayList;
/**
 *
 * @author ALEJANDRO ROSADO
 */


public class AgendaApp extends JMiniApp {

    private ContactRepository repository;
    private AgendaView view;

    public AgendaApp(JMiniAppConfig config) {
        super(config);
    }

    @Override
    protected void initialize() {
        this.view = new AgendaView();
        this.repository = new ContactRepository();

        repository.loadData(context.getData());

        repository.setValidator(contact -> {
            if (contact.getName().length() < 3) {
                view.showMessage("Error: Name is too short (min 3 chars)!");
                return false;
            }
            return true;
        });

        repository.addObserver(contact -> {
            System.out.println("[LOG] New contact added to database: " + contact.getName());
        });
    }

    @Override
    protected void run() {
        boolean isRunning = true;
        while (isRunning) {
            String option = view.showMenuAndGetOption();
            switch (option) {
                case "1":
                    view.showContacts(repository.getAll());
                    break;
                case "2":
                    Contact c = view.getNewContactInput();
                    boolean success = repository.add(c);
                    if (success) {
                        view.showMessage("Saved successfully.");
                    }
                    break;
                case "3":
                    isRunning = false;
                    break;
                default:
                    view.showMessage("Invalid option.");
            }
        }
    }

    @Override
    protected void shutdown() {
        view.showMessage("Shutting down...");
        context.setData(new ArrayList<>(repository.getAll()));
    }

    public static void main(String[] args) {
        JMiniAppRunner.forApp(AgendaApp.class)
                .withState(Contact.class)
                .run(args);
    }
}
