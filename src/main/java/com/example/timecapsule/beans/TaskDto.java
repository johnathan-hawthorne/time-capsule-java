package com.example.timecapsule.beans;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class TaskDto {
    public long id;
    public Long taskTypeId;
    public String name;
    public String startDateTime;
    public String endDateTime;
    public String elapsedTime;

    public TaskDto(Task task) {
        this.id = task.id;
        this.taskTypeId = task.taskTypeId;
        this.name = task.name;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        this.startDateTime = task.startDateTime.format(formatter);
        this.endDateTime = task.endDateTime.format(formatter);
        this.elapsedTime = FormatElapsedTime(task.elapsedTime);
    }

    private String FormatElapsedTime(Duration elapsedTime) {
        String hours = elapsedTime.toHoursPart() < 10 ? "0" + elapsedTime.toHoursPart() : "" + elapsedTime.toHoursPart();
        String mins;
        if (elapsedTime.toMinutesPart() >= 60) {
            mins = "00";
        } else {
            mins = elapsedTime.toMinutesPart() < 10 ? "0" + elapsedTime.toMinutesPart() : "" + elapsedTime.toMinutesPart();
        }
        String seconds;
        if (elapsedTime.toSecondsPart() >= 60) {
            seconds = "00";
        } else {
            seconds = elapsedTime.toSecondsPart() < 10 ? "0" + elapsedTime.toSecondsPart() : "" + elapsedTime.toSecondsPart();
        }

        return String.format("%s:%s:%s", hours, mins, seconds);
    }
}
