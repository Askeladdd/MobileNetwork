package com.company.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Person {

    private long id; //Идентификатор
    private static final AtomicInteger count = new AtomicInteger(0); //Счетчик
    private String firstName; //ФИО
    private String patronymic;
    private String lastName;
    private String passport; //Номер паспорта
    private String address; //Адрес

    public Person(String firstName, String patronymic, String lastName, String passport, String address) {
        id = count.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.passport = passport;
        this.address = address;
    }

    public Person(int id, String firstName, String patronymic, String lastName, String passport, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.passport = passport;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPassport() {
        return passport;
    }

    public String getAddress() {
        return address;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", passport='" + passport + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
