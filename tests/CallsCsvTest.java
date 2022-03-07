import com.company.csv.CallsCsv;
import com.company.csv.PersonsCsv;
import com.company.csv.VolumesCsv;
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
class CallsCsvTest {
    private final  Calls  calls = new  Calls();
    private final String fileName = "src/com/company/data/calls.csv";

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
        Call call1 = new Call("12345-12-1234567","12345-12-1234568", "06-03-2022 11:50:55",  "06-03-2022 11:50:58");
        Call call2 = new Call("12345-12-1234568","12345-12-1234569", "06-03-2022 11:50:55",  "06-03-2022 11:50:58");
        calls.add(call1);
        calls.add(call2);

        CallsCsv callsCsv = new CallsCsv(calls);
        try {
            callsCsv.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(fileName);
        assertTrue(file.exists(), "File is created");
    }

    @Test
    @Order(3)
    void readFile() {
       Calls callsNew = new Calls();
        Call call1 = new Call("12345-12-1234567","12345-12-1234568", "06-03-2022 11:50:55",  "06-03-2022 11:50:58");
        Call call2 = new Call("12345-12-1234568","12345-12-1234569", "06-03-2022 11:50:55",  "06-03-2022 11:50:58");
        callsNew.add(call1);
        callsNew.add(call2);

        CallsCsv callsCsv = new CallsCsv(calls);
        try {
            callsCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Проверить 1-ю запись
        boolean result = callsCsv.getCalls().getCalls().get(0).toString().equals(callsNew.getCalls().get(0).toString());
        //callsNew.getCalls().forEach(call->System.out.println(call));
        //callsCsv.getCalls().getCalls().forEach(call->System.out.println(call));
        assertTrue(result, "File contains right values");
    }
}