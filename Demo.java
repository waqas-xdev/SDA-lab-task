/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fa22-bse-129
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.File;

// EventListener Interface
interface EventListener {
    void update(String eventType, File file);
}

// Editor Class
class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}

// LogOpenListener Class
 class LogOpenListener implements EventListener {
    private File log;

    public LogOpenListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save to log " + log.getName() + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}

// EmailNotificationListener Class
class EmailNotificationListener implements EventListener {
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Email to " + email + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}

// EventManager Class


class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void notify(String eventType, File file) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
}

// Demo Class
public class Demo {
    public static void main(String[] args) {
        // Create an instance of the Editor
        Editor editor = new Editor();
        
        // Subscribe to events
        editor.events.subscribe("open", new LogOpenListener("log.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            // Open a file
            editor.openFile("test.txt"); // Ensure this file exists in your working directory
            // Save the file
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace(); // Print any exception that occurs
        }
    }
}