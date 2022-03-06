package com.company.csv;

import com.company.model.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PlansCsv {
    private Plans plans; //Список планов
    String[] Headers = { "id", "name", "volumes"};
    private String fileName = "src/com/company/data/plans.csv";

    public PlansCsv(Plans plans) {
        this.plans = plans;
    }

    public Plans getPlans() {
        return plans;
    }

    public void write() throws IOException {
        FileWriter out = new FileWriter(fileName);
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(Headers))) {
            plans.getPlans().stream()
                    .forEach(plan ->
                    {
                        try {
                            printer.printRecord(plan.getId(), plan.getName(), Arrays.toString(plan.getIdsVolumes().toArray()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    public void read() throws IOException {
        Reader in = new FileReader(fileName);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(Headers).withSkipHeaderRecord(true).parse(in);
        plans.getPlans().clear();

        Volumes volumes = new Volumes();
        VolumesCsv volumesCsv = new VolumesCsv(volumes);
        volumesCsv.read();
        //volumesCsv.getVolumes().getVolumes().forEach(volume-> System.out.println(volume));

        for (CSVRecord record : records) {
            long id = Long.parseLong(record.get(0));
            String name = record.get(1);
            Plan plan = new Plan(id, name);

            String[] arr =  record.get(2).replace("[", "").replace ("]", "").split (",");
            ArrayList<Long> ids = Arrays.asList(arr).stream()
                    .map(s->s.trim())
                    .filter(s->!s.isEmpty())
                    .map(s->Long.parseLong(s))
                    .collect(Collectors.toCollection(ArrayList::new));
            //System.out.println(Arrays.toString(ids.toArray()));

            if (ids.size()>0)
           ids.stream().forEach(idVolume->plan.addVolume(volumesCsv.getVolumes().getById(idVolume)));
           plans.add(plan);
        }

        //plans.getPlans().stream().forEach(plan-> System.out.println(plan));
    }
}
