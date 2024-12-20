package com.example.timecapsule.beans;

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
        // TODO: time formatting needs work
        String hours = task.elapsedTime.toHoursPart() < 10 ? "0" + task.elapsedTime.toHoursPart() : "" + task.elapsedTime.toHoursPart();
        String mins;
        if (task.elapsedTime.toMinutesPart() >= 60) {
            mins = "00";
        } else {
            mins = task.elapsedTime.toMinutesPart() < 10 ? "0" + task.elapsedTime.toMinutesPart() : "" + task.elapsedTime.toMinutesPart();
        }
        String seconds;
        if (task.elapsedTime.toSecondsPart() >= 60) {
            seconds = "00";
        } else {
            seconds = task.elapsedTime.toSecondsPart() < 10 ? "0" + task.elapsedTime.toSecondsPart() : "" + task.elapsedTime.toSecondsPart();
        }
        this.elapsedTime = String.format("%s:%s:%s", hours, mins, seconds);
    }
}
