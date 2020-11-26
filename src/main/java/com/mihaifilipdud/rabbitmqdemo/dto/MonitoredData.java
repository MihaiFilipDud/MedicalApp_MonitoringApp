package com.mihaifilipdud.rabbitmqdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonitoredData {

    private UUID patient_id;
    private Date start;
    private Date end;
    private String activity;


    public long timeDif() {
        return Math.abs(end.getTime() - start.getTime());
    }

}
