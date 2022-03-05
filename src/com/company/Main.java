package com.company;

import com.company.csv.PersonsCsv;
import com.company.csv.SubscribersCsv;
import com.company.model.*;

import java.io.IOException;

/*
Приложение, управляющее балансом абонентов мобильной телефонной сети.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        //Список людей
        Persons persons = new Persons();
        Person person = new Person("Иван", "Иванович", "Иванов", "МВ2342346", "Витебск");
        Person person2 =new Person("Петр", "Петрович", "Петров", "МВ1343434", "Витебск");
        persons.add(person);
        persons.add(person2);

        PersonsCsv personsCsv = new PersonsCsv(persons);
        personsCsv.write();
        //personsCsv.read();


        //Список абонентов
        Subscribers subscribers = new Subscribers();

        Subscriber subscriber = new Subscriber(persons.getPersons().get(0));
        subscriber.setPlan(new Plan("План А"));
        subscriber.addNumber("23434234");

        Subscriber subscriber2 = new Subscriber(persons.getPersons().get(1));
        subscriber2.setPlan(new Plan("План Б"));
        subscriber2.addNumber("1111111");
        subscriber2.addNumber("2222222");

        subscribers.add(subscriber);
        subscribers.add(subscriber2);
        SubscribersCsv subscribersCsv = new SubscribersCsv(subscribers);
        subscribersCsv.write();
        subscribersCsv.read();

    }
}
