package com.company.model;

import java.util.LinkedList;

public class Subscribers {
    public LinkedList<Subscriber> getSubscribers() {
        return subscribers;
    }

    private LinkedList<Subscriber> subscribers = new LinkedList<>(); //Список абонентов

    public void add(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    public void remove(Subscriber subscriber){
        subscribers.remove(subscriber);
    }
}
