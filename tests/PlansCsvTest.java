import com.company.csv.PersonsCsv;
import com.company.csv.PlansCsv;
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
class PlansCsvTest {
    private final Plans plans = new Plans();
    private final String fileName = "src/com/company/data/plans.csv";

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
        Volumes volumes = new Volumes();
        VolumesCsv volumesCsv = new VolumesCsv(volumes);
        try {
            volumesCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Plan plan1 = new Plan("План А");
        for (int i=1; i<=8; i++)
            plan1.addVolume(volumes.getById(i));

        Plan plan2 = new Plan("План Б");
        for (int i=9; i<=20; i++)
            plan2.addVolume(volumes.getById(i));

        Plan plan3 = new Plan("План В");
        for (int i=21; i<=32; i++)
            plan3.addVolume(volumes.getById(i));

        Plan plan4 = new Plan("План Г");
        for (int i=33; i<=45; i++)
            plan4.addVolume(volumes.getById(i));

        plans.add(plan1);
        plans.add(plan2);
        plans.add(plan3);
        plans.add(plan4);

        PlansCsv plansCsv = new PlansCsv(plans);
        try {
            plansCsv.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(fileName);
        assertTrue(file.exists(), "File is created");
    }

    @Test
    @Order(3)
    void readFile() {
        Volumes volumes = new Volumes();
        VolumesCsv volumesCsv = new VolumesCsv(volumes);
        try {
            volumesCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Plans plansNew = new Plans();

        Plan plan1 = new Plan("План А");
        for (int i=1; i<=8; i++)
            plan1.addVolume(volumes.getById(i));

        plansNew.add(plan1);

        PlansCsv plansCsv = new PlansCsv(plans);
        try {
            plansCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Проверить 1-ю запись
        boolean result = plansCsv.getPlans().getPlans().get(0).toString().equals(plansNew.getPlans().get(0).toString());
        //plansNew.getPlans().forEach(plan->System.out.println(plan));
        //plansCsv.getPlans().getPlans().forEach(plan->System.out.println(plan));
        assertTrue(result, "File contains right values");
    }
}