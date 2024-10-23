/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.task1;

/**
 *
 * @author waqas
 */


import java.util.ArrayList;
import java.util.List;

// Abstract Observer
abstract class Observer {
    protected Subject subject;
    public abstract void update();
}

// Concrete Observers
class HexaObserver extends Observer {
    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}

class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}

class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}

// Subject
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Main Application
public class Task1 {
    public static void main(String[] args) {
        Subject subject = new Subject();

        HexaObserver hexObserver = new HexaObserver(subject);
        OctalObserver octObserver = new OctalObserver(subject);
        BinaryObserver binObserver = new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);

        // Detach the HexaObserver
        subject.detach(hexObserver);

        // Change the state after detaching HexaObserver
        System.out.println("Second state change: 10");
        subject.setState(10);  // Only Binary and Octal observers should be notified
    }
}