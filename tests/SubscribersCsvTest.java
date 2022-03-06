import com.company.csv.PersonsCsv;
import com.company.csv.SubscribersCsv;
import com.company.model.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SubscribersCsvTest {
    private final Subscribers subscribers = new Subscribers();
    private final String fileName = "src/com/company/data/subscribers.csv";
    private Persons persons = new Persons();

    @Test
    @Order(1)
    void deleteFile() {
        File file = new File(fileName);
        boolean result = false;
        try {
            result = Files.deleteIfExists(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(result, "File is deleted");
    }

    @Test
    @Order(2)
    void writeFile() {
        PersonsCsv personsCsv = new PersonsCsv(persons);
        try {
            personsCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        persons = personsCsv.getPersons();

        Subscriber subscriber1 = new Subscriber(persons.getPersons().get(0));
        subscriber1.setPlan(new Plan("План А"));
        subscriber1.setNumber("23434234");

        Subscriber subscriber2 = new Subscriber(persons.getPersons().get(1));
        subscriber2.setPlan(new Plan("План Б"));
        subscriber2.setNumber("1111111");

        subscribers.add(subscriber1);
        subscribers.add(subscriber2);
        SubscribersCsv subscribersCsv = new SubscribersCsv(subscribers);

        try {
            subscribersCsv.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(fileName);
        assertTrue(file.exists(), "File is created");
    }

    @Test
    @Order(3)
    void readFile() {
       Persons personsNew = new Persons();
        Person person1 = new Person("Иванов","Иван", "Иванович",  "МВ2342346", "Витебск");
        Person person2 =new Person("Петров", "Петр", "Петрович", "МВ1343434", "Витебск");
        personsNew.add(person1);
        personsNew.add(person2);

        Subscribers subscribersNew = new Subscribers();
        Subscriber subscriber1 = new Subscriber(personsNew.getPersons().get(0));
        subscriber1.setPlan(new Plan("План А"));
        subscriber1.setNumber("23434234");

        Subscriber subscriber2 = new Subscriber(personsNew.getPersons().get(1));
        subscriber2.setPlan(new Plan("План Б"));
        subscriber2.setNumber("1111111");

        subscribersNew.add(subscriber1);
        subscribersNew.add(subscriber2);

        SubscribersCsv subscribersCsv = new SubscribersCsv(subscribers);
        try {
            subscribersCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Проверить 1-ю запись
        boolean result = subscribersCsv.getSubscribers().getSubscribers().get(0).toString().equals(subscribersNew.getSubscribers().get(0).toString());
        subscribersNew.getSubscribers().forEach(subscriber->System.out.println(subscriber));
        subscribersCsv.getSubscribers().getSubscribers().forEach(subscriber->System.out.println(subscriber));
        assertTrue(result, "File contains right values");
    }
}