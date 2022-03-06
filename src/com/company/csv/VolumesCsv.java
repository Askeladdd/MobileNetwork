package com.company.csv;

import com.company.model.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

public class VolumesCsv {
    private Volumes volumes; //Список абонентов
    String[] Headers = { "id", "name", "unit", "price"};
    String fileName = "src/com/company/data/volumes.csv";

    public VolumesCsv(Volumes volumes) {
        this.volumes = volumes;
    }

    public Volumes getVolumes() {
        return volumes;
    }

    public void write() throws IOException {
        FileWriter out = new FileWriter(fileName);
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(Headers))) {
            volumes.getVolumes().stream()
                    .forEach(volume ->
                    {
                        try {
                            printer.printRecord(volume.getId(), volume.getName(),
                                    volume.getUnit(), volume.getPrice());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    public void read() throws IOException {

        Reader in = new FileReader(fileName);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(Headers).withSkipHeaderRecord(true).parse(in);
        volumes.getVolumes().clear();
        for (CSVRecord record : records) {

            int id = Integer.parseInt(record.get(0));
            String name =record.get(1);
            String value = record.get(2);
            String price = record.get(3);

            Volume volume = new Volume(id, name, value, Long.parseLong(price));
            volumes.add(volume);

        }

        //volumes.getVolumes().stream().forEach(volume-> System.out.println(volume));
    }

}