package com.example.luxeauraapp.models;


import java.time.LocalDate;
import java.time.LocalTime;

public class TimeSlotModel {

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public TimeSlotModel(LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

}
