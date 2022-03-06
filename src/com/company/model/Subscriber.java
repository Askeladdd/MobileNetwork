package com.company.model;

import java.util.Arrays;
import java.util.List;

/*
Абонент мобильной сети (номер телефона)
 */
public class Subscriber {
    private Person person; //Личные данные
    private String number; //Номера абонента
    private long balance; //Баланс (коп.)
    private Plan plan;

    public Subscriber(Person person){
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public  String getNumber() {
        return number;
    }

    public long getBalance() {
        return balance;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getId(){
        return person.getId();
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "number=" + number +
                ", balance=" + balance +
                ", plan=" + plan.getName() +
                '}';
    }
}
