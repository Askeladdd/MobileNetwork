package com.company.csv;

import com.company.model.Person;
import com.company.model.Persons;
import com.company.model.Subscriber;
import com.company.model.Subscribers;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class SubscribersCsv {
    private Subscribers subscribers; //Список абонентов
    String[] Headers = { "id", "numbers", "balance", "plan"};

    public SubscribersCsv(Subscribers subscribers) {
        this.subscribers = subscribers;
    }

    public void write() throws IOException {
        FileWriter out = new FileWriter("src/com/company/data/subscribers.csv");
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(Headers))) {
            subscribers.getSubscribers().stream()
                    .forEach(subscriber ->
                    {
                        try {
                            printer.printRecord(subscriber.getPerson().getId(), Arrays.toString(subscriber.getNumbers().toArray()),
                                    subscriber.getBalance(), subscriber.getPlan().getName());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    public void read() throws IOException {
        Persons persons = new Persons();

        PersonsCsv personsCsv = new PersonsCsv(persons);
        personsCsv.read();

        Reader in = new FileReader("src/com/company/data/subscribers.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(Headers).withSkipHeaderRecord(true).parse(in);
        subscribers.getSubscribers().clear();
        for (CSVRecord record : records) {
            //System.out.println(record.get(0));

            int id = Integer.parseInt(record.get(0));
            Person person = persons.getById(id);
            Subscriber subscriber = new Subscriber(person);
            subscribers.add(subscriber);
            String[] arr = record.get(1).replaceAll("^[\\s]+|[\\s]+$|\\[|\\]","").split(",");
            subscriber.setNumbers(Arrays.asList(arr));
            subscriber.setBalance(Integer.parseInt(record.get(2)));
            //subscribers.getSubscribers().get(id).setPlan(record.get(2)); ? Plan
        }

        subscribers.getSubscribers().stream().forEach(subscriber-> System.out.println(subscriber));
    }

}
