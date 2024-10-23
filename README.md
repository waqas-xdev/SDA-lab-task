# SDA-lab-task
Project: 1
Overview
This project demonstrates the Observer Design Pattern, where multiple observers are attached to a subject and get notified when the subject's state changes. The project includes three concrete observers:

HexaObserver: Displays the subject's state in hexadecimal format.
OctalObserver: Displays the subject's state in octal format.
BinaryObserver: Displays the subject's state in binary format.
Key Features
Subject: Maintains a list of observers and notifies them of any state changes.
Observer: Abstract class that concrete observers like HexaObserver, OctalObserver, and BinaryObserver extend.
Observers can be attached to or detached from the subject dynamically.
Upon state change, only the attached observers are notified.


How It Works
State Changes: The Subject class contains a setState() method that notifies all attached observers whenever the state changes.
Observer Notification: When a state change occurs, each observer's update() method displays the current state in their respective format (hexadecimal, octal, or binary).
Detach Example: After the first state change, the HexaObserver is detached, and hence, it does not get notified of subsequent state changes.
How to Run
Clone the repository and navigate to the project directory.
Compile and run Task1.java to see the observer pattern in action.




Project: task 2
Overview
This project demonstrates an Event Notification System, where different listeners subscribe to specific events, such as opening or saving a file. The system notifies these listeners when an event occurs. This implementation showcases how file operations can trigger different actions like logging and sending notifications.

Key Components
EventListener: An interface that defines the update() method to be implemented by concrete listeners.
Editor: A class that simulates file operations (open and save). It uses an EventManager to manage event subscriptions and notifications.
LogOpenListener: Logs a message whenever a file is opened.
EmailNotificationListener: Sends an email notification when a file is saved.
EventManager: Handles subscription of listeners and notification of events.

How It Works
EventManager: The EventManager class allows listeners to subscribe to events like open and save.
File Operations: The Editor class performs file operations. When a file is opened or saved, the corresponding event is triggered, and all the listeners subscribed to that event are notified.
Listeners: The LogOpenListener writes to a log file when a file is opened, and the EmailNotificationListener sends a notification when the file is saved.
How to Run
Clone the repository and navigate to the project directory.
Make sure a file named test.txt exists in your working directory.
Compile and run Demo.java to see the event notification system in action.
How It Works:
When you open the file, the system logs the event to log.txt.
When you save the file, it triggers an email notification to admin@example.com (this is a simulation and will print the message to the console).

