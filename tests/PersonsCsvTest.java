import com.company.csv.PersonsCsv;
import com.company.csv.VolumesCsv;
import com.company.model.Person;
import com.company.model.Persons;
import com.company.model.Volume;
import com.company.model.Volumes;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonsCsvTest {
    private final Persons persons = new Persons();
    private final String fileName = "src/com/company/data/persons.csv";

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
        Person person = new Person("Иванов","Иван", "Иванович",  "МВ2342346", "Витебск");
        Person person2 =new Person("Петров","Петр", "Петрович",  "МВ1343434", "Витебск");
        persons.add(person);
        persons.add(person2);

        PersonsCsv personsCsv = new PersonsCsv(persons);
        try {
            personsCsv.write();
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

        PersonsCsv personsCsv = new PersonsCsv(persons);
        try {
            personsCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Проверить 1-ю запись
        boolean result = personsCsv.getPersons().getPersons().get(0).toString().equals(personsNew.getPersons().get(0).toString());
        //personsNew.getPersons().forEach(person->System.out.println(person));
        //personsCsv.getPersons().forEach(person->System.out.println(person));
        assertTrue(result, "File contains right values");
    }
}