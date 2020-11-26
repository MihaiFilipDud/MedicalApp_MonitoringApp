package com.mihaifilipdud.rabbitmqdemo.DataAcquisition;

import com.mihaifilipdud.rabbitmqdemo.dto.MonitoredData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class MonitoredDataReceiver {


    private static UUID patient_ID = UUID.fromString("ed1b6e0b-130f-46fe-a2a2-c6cc8a87995e");

    public static List<MonitoredData> getData() {

        List<MonitoredData> data = new ArrayList<MonitoredData>();

        Stream<String> lines = null;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            lines = Files.lines(Paths.get("activity.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        lines.forEach(line -> {
            String[] l = line.split("	");
            Date start = null;
            Date end = null;
            try {
                start = f.parse(l[0]);
                end = f.parse(l[2]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            MonitoredData m = new MonitoredData(patient_ID, start, end, l[4]);
            data.add(m);
        });

        return data;
    }
}
