package com.company.csv;

import com.company.model.Person;
import com.company.model.Persons;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class PersonsCsv {
    private Persons persons; //Список абонентов
    String[] Headers = { "id", "second_name", "first_name",  "patronymic", "passport", "address"};
    private String fileName = "src/com/company/data/persons.csv";

    public PersonsCsv(Persons persons) {
        this.persons = persons;
    }

    public Persons getPersons() {
        return persons;
    }

    public void write() throws IOException {
        FileWriter out = new FileWriter(fileName);
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(Headers))) {
            persons.getPersons().stream()
                    .forEach(person ->
                    {
                        try {
                            printer.printRecord(person.getId(), person.getLastName(),person.getFirstName(), person.getPatronymic(),
                                    person.getPassport(), person.getAddress());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    public void read() throws IOException {
        Reader in = new FileReader(fileName);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(Headers).withSkipHeaderRecord(true).parse(in);
        persons.getPersons().clear();
        for (CSVRecord record : records) {
            persons.add(new Person(Integer.parseInt(record.get(0)), record.get(1), record.get(2), record.get(3),record.get(4), record.get(5)));
        }

        //persons.getPersons().stream().forEach(person-> System.out.println(person));
    }
}
