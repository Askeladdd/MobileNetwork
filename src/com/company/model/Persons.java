package com.company.model;

import java.util.LinkedList;
import java.util.Optional;

public class Persons {
    private LinkedList<Person> persons = new LinkedList<>(); //Список людей

    public LinkedList<Person> getPersons() {
        return persons;
    }
    public void add(Person person){
        persons.add(person);
    }

    public void remove(Person person){
        persons.remove(person);
    }

    public Person getById(int id){
        Person result = null;
        result = persons.stream().filter(person->person.getId()==id).findFirst().get();
        return result;
    }
}
