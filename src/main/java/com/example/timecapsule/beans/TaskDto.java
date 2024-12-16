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
        this.elapsedTime = String.format("0%d:0%d:0%d", task.elapsedTime.toHours(), task.elapsedTime.toMinutes(),
                task.elapsedTime.toSeconds());
    }
}
