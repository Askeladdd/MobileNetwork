import com.company.csv.VolumesCsv;
import com.company.model.Volume;
import com.company.model.Volumes;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VolumesCsvTest {
    private final Volumes volumes = new Volumes();
    private final VolumesCsv volumesCsv = new VolumesCsv(volumes);
    private final String fileName = "src/com/company/data/volumes.csv";

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
        Volume volume1 = new Volume("Звонки внутри сети", "мин", 1);
        Volume volume2 = new Volume("Звонки в другие сети", "мин", 2);
        Volume traffic = new Volume("Internet Traffic", "Mb",1);
        volumes.add(volume1);
        volumes.add(volume2);
        volumes.add(traffic);

        VolumesCsv volumesCsv = new VolumesCsv(volumes);
        try {
            volumesCsv.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(fileName);
        assertTrue(file.exists(), "File is created");
    }

    @Test
    @Order(3)
    void readFile() {
       Volumes volumesNew = new Volumes();
        Volume volume1 = new Volume("Звонки внутри сети", "мин", 1);
        Volume volume2 = new Volume("Звонки в другие сети", "мин", 2);
        Volume traffic = new Volume("Internet Traffic", "Mb",1);
        volumesNew.add(volume1);
        volumesNew.add(volume2);
        volumesNew.add(traffic);

        VolumesCsv volumesCsvNew = new VolumesCsv(volumesNew);
        try {
            volumesCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Проверить 1-ю запись
        boolean result = volumesCsv.getVolumes().getVolumes().get(0).toString().equals(volumesNew.getVolumes().get(0).toString());
        //System.out.println(volumesCsv.getVolumes().getVolumes().get(0).toString());
        //volumesNew.getVolumes().forEach(volume->System.out.println(volume));
        //volumesCsv.getVolumes().getVolumes().forEach(volume->System.out.println(volume));
        assertTrue(result, "File contains right values");
    }
}