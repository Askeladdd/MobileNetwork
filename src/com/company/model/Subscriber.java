package com.company.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Абонент мобильной сети
 */
public class Subscriber {

    Person person; //Личные данные

    private List<String> numbers = new LinkedList<>(); //Номера абонента
    private long balance; //Баланс (коп.)
    private Plan plan;

    public Subscriber(Person person){

        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void addNumber(String number){
        numbers.add(number);
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public  List<String> getNumbers() {
        return numbers;
    }

    public long getBalance() {
        return balance;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public long getId(){
        return person.getId();
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "numbers=" + Arrays.toString(numbers.toArray()) +
                ", balance=" + balance +
                ", plan=" + plan +
                '}';
    }
}
