Agenda App

A Contact Management System built with the JMiniApp Framework.
Demonstrates a clean architecture using MVC, Repository, Observer.

Features
MVC Architecture:Clean separation between Data, UI, and Logic.
Persistence:Automatically saves contacts to memory/file upon exit.
Hot Spots: Customizable validation and event handling.

How to Run:
To run this application, use the following Maven command:

bash
mvn exec:java -Dexec.mainClass="com.alondre2001.agenda.AgendaApp"

The project structure is as follows:
AgendaApp.java: Main Controller.
ContactRepository.java: Data layer.
AgendaView.java: User Interface.
ContactObserver.java: Hot Spot.
ContactValidator.java: Hot Spot.
