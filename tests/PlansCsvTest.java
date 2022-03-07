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
        for (int i=1; i<=4; i++)
        plan1.addVolume(volumes.getById(i));

        plan1.addVolume(volumes.getById(7));

        Plan plan2 = new Plan("План Б");
        plans.add(plan1);
        plans.add(plan2);

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
        Plans plansNew = new Plans();

        Volume volume1 = new Volume(1, "Звонки внутри сети", "мин", 1);
        Volume volume2 = new Volume(2, "Звонки в другие сети", "мин", 2);
        Plan plan1 = new Plan(1, "План А");
        Plan plan2 = new Plan(2, "План Б");
        plan1.addVolume(volume1);
        plan1.addVolume(volume2);

        plansNew.add(plan1);
        plansNew.add(plan2);

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