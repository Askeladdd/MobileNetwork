import com.company.csv.VolumesCsv;
import com.company.model.Volume;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.company.model.Volumes;


import static org.junit.jupiter.api.Assertions.assertTrue;

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
        Volume volume1 = new Volume("Звонки внутри сети", "1 мин", 2500);
        Volume volume2 = new Volume("Звонки в другие сети", "1 мин", 12500);
        Volume volume3 = new Volume("Звонки на стационарную сеть", "1 мин",9500);
        Volume volume4 = new Volume("Роуминг", "мин",250000);
        Volume volume5 = new Volume("тарификация по 10 сек", "10 сек",2500);
        Volume volume6 = new Volume("SMS", "1",15000);
        Volume volume7 = new Volume("SMS в роуминге", "1",150000);
        Volume traffic1 = new Volume("Internet Traffic", "час",300000);

        Volume volume8 = new Volume("Звонки внутри сети (первая минута)", "first мин", 500);
        Volume volume9 = new Volume("Звонки внутри сети (последующие минуты)", "after 1 мин", 5000);
        Volume volume10 = new Volume("Звонки в другие сети (первая минута)", "first мин", 7500);
        Volume volume11 = new Volume("Звонки в другие сети (последующие минуты)", "after 1 мин", 50000);
        Volume volume12 = new Volume("Звонки на стационарную сеть (первая минута)", "first мин",5000);
        Volume volume13 = new Volume("Звонки на стационарную сеть (последующие минуты)", "after 1 мин",25000);
        Volume volume14 = new Volume("Роуминг", "мин",500000);
        Volume volume15 = new Volume("тарификация по 10 сек", "10 сек",2500);
        Volume volume16 = new Volume("SMS", "1",15000);
        Volume volume17 = new Volume("SMS в роуминге", "1",100000);
        Volume traffic2 = new Volume("Internet Traffic", "first 50 Mb",100000);
        Volume traffic3 = new Volume("Internet Traffic", "after 50 Mb",125000);

        Volume volume18 = new Volume("Звонки внутри сети (первая минута)", "first мин", 10000);
        Volume volume19 = new Volume("Звонки внутри сети (последующие минуты)", "after 1 мин", 500);
        Volume volume20 = new Volume("Звонки в другие сети (первая минута)", "first мин", 10000);
        Volume volume21 = new Volume("Звонки в другие сети (последующие минуты)", "after 1 мин", 2500);
        Volume volume22 = new Volume("Звонки на стационарную сеть (первая минута)", "first мин",10000);
        Volume volume23 = new Volume("Звонки на стационарную сеть (последующие минуты)", "after 1 мин",2500);
        Volume volume24 = new Volume("Роуминг", "мин",100000);
        Volume volume25 = new Volume("тарификация по 1 мин", "1 мин",2500);
        Volume volume26 = new Volume("SMS", "1",15000);
        Volume volume27 = new Volume("SMS в роуминге", "1",15000);
        Volume traffic4 = new Volume("Internet Traffic", "first 50 Mb",100000);
        Volume traffic5 = new Volume("Internet Traffic", "after 50 Mb",125000);

        Volume volume28 = new Volume("Звонки внутри сети (первая минута)", "first мин", 50000);
        Volume volume29 = new Volume("Звонки внутри сети (последующие минуты)", "after 1 мин", 10000);
        Volume volume30 = new Volume("Звонки в другие сети (первая минута)", "first мин", 50000);
        Volume volume31 = new Volume("Звонки в другие сети (последующие минуты)", "after 1 мин", 10000);
        Volume volume32 = new Volume("Звонки на стационарную сеть (первая минута)", "first мин",50000);
        Volume volume33 = new Volume("Звонки на стационарную сеть (последующие минуты)", "after 1 мин",10000);
        Volume volume34 = new Volume("Роуминг", "мин",50000);
        Volume volume35 = new Volume("тарификация по 10 сек", "10 сек",2500);
        Volume volume36 = new Volume("SMS", "1",15000);
        Volume volume37 = new Volume("SMS в роуминге", "1",500000);
        Volume traffic6 = new Volume("Internet Traffic", "first 100 Mb",50000);
        Volume traffic7 = new Volume("Internet Traffic", "100-500 Mb",100000);
        Volume traffic8 = new Volume("Internet Traffic", "after 500 Mb",500000);

        volumes.add(volume1);
        volumes.add(volume2);
        volumes.add(volume3);
        volumes.add(volume4);
        volumes.add(volume5);
        volumes.add(volume6);
        volumes.add(volume7);
        volumes.add(traffic1);

        volumes.add(volume8);
        volumes.add(volume9);
        volumes.add(volume10);
        volumes.add(volume11);
        volumes.add(volume12);
        volumes.add(volume13);
        volumes.add(volume14);
        volumes.add(volume15);
        volumes.add(volume16);
        volumes.add(volume17);
        volumes.add(traffic2);
        volumes.add(traffic3);

        volumes.add(volume18);
        volumes.add(volume19);
        volumes.add(volume20);
        volumes.add(volume21);
        volumes.add(volume22);
        volumes.add(volume23);
        volumes.add(volume24);
        volumes.add(volume25);
        volumes.add(volume26);
        volumes.add(volume27);
        volumes.add(traffic4);
        volumes.add(traffic5);

        volumes.add(volume28);
        volumes.add(volume29);
        volumes.add(volume30);
        volumes.add(volume31);
        volumes.add(volume32);
        volumes.add(volume33);
        volumes.add(volume34);
        volumes.add(volume35);
        volumes.add(volume36);
        volumes.add(volume37);
        volumes.add(traffic6);
        volumes.add(traffic7);
        volumes.add(traffic8);

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