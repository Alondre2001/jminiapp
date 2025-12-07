```markdown
---
id: agenda
title: Agenda App
sidebar_label: Agenda App
---

Building a Professional Agenda App

In this tutorial, we will build a Contact Management application that demonstrates advanced usage of JMiniApp, including the implementation of MVC, Observer.

The Model (Data)
First, we define our data structure. A simple POJO representing a Contact.

```java
public class Contact {
    private String name;
    private String phone;
    // Getters, Setters and Constructors...
}
Flexibility
Define interfaces to allow future extensions without modifying the core code.

Strategy Pattern (Validation):
public interface ContactValidator {
    boolean isValid(Contact contact);
}

Observer Pattern (Notification):

public interface ContactObserver {
    void onContactAdded(Contact contact);
}

The Repository
Implement a Repository to handle data access. The logic "Validate -> Add -> Notify" is a Frozen Spot.

public class ContactRepository {
    // ... list of contacts ...

    public boolean add(Contact contact) {
        if (validator.isValid(contact)) {
            contacts.add(contact);
            notifyObservers(contact);
            return true;
        }
        return false;
    }
}

The Controller
Finally, our Main App connects everything using the JMiniApp lifecycle.

public class AgendaApp extends JMiniApp {
    @Override
    protected void initialize() {
        repository.setValidator(c -> c.getName().length() > 3);
        repository.addObserver(c -> System.out.println("New Contact: " + c.getName()));
    }
    
    //run() and shutdown() implementations
}

Conclusion
By using JMiniApp, we successfully created a modular application where:
Frozen Spots (Repository logic) ensure data integrity.
Hot Spots (Validator/Observer) allow custom behaviors.
Persistence is handled automatically by the framework.