package com.company.csv;

import com.company.model.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class CallsCsv {
    private Calls calls; //Список звонков
    String[] Headers = { "id", "number_from", "number_to",  "date_begin", "date_end"};
    private String fileName = "src/com/company/data/calls.csv";

    public CallsCsv(Calls calls) {
        this.calls = calls;
    }

    public Calls getCalls() {
        return calls;
    }

    public void write() throws IOException {
        FileWriter out = new FileWriter(fileName);
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(Headers))) {
            calls.getCalls().stream()
                    .forEach(call ->
                    {
                        try {
                            printer.printRecord(call.getId(), call.getNumFrom(), call.getNumTo(), call.getsDateBegin(),
                                    call.getsDateEnd());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    public void read() throws IOException {
        Reader in = new FileReader(fileName);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(Headers).withSkipHeaderRecord(true).parse(in);
        calls.getCalls().clear();
        for (CSVRecord record : records) {
            calls.add(new Call(Integer.parseInt(record.get(0)), record.get(1), record.get(2), record.get(3),record.get(4)));
        }

        calls.getCalls().stream().forEach(call-> System.out.println(call));
    }
}