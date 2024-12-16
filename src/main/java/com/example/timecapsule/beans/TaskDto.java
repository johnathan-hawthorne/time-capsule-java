package com.example.timecapsule.beans;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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
        String hours = task.elapsedTime.toHours() < 10 ? "0" + task.elapsedTime.toHours() : "" + task.elapsedTime.toHours();
        String mins = task.elapsedTime.toMinutes() < 10 ? "0" + task.elapsedTime.toMinutes() : "" + task.elapsedTime.toMinutes();
        String seconds;
        if (task.elapsedTime.toSeconds() > 60) {
            seconds = "00";
        } else {
            seconds = task.elapsedTime.toSeconds() < 10 ? "0" + task.elapsedTime.toSeconds() : "" + task.elapsedTime.toSeconds();
        }
        this.elapsedTime = String.format("%s:%s:%s", hours, mins, seconds);
    }
}
