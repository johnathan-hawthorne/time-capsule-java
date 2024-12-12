package com.example.timecapsule.beans;

import java.time.format.DateTimeFormatter;

public class TaskDto {
    public long id;
    public Long taskTypeId;
    public String name;
    public String startDateTime;
    public String endDateTime;
    public String elapsedTime;

    public TaskDto(Task task) {
        this.id = task.id;
        this.name = task.name;
        // TODO: time formatting needs work
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss B");
        this.startDateTime = task.startDateTime.format(formatter);
        this.endDateTime = task.endDateTime.format(formatter);
        this.elapsedTime = String.format("%d:%d:%d", task.elapsedTime.toHours(), task.elapsedTime.toMinutes(),
                task.elapsedTime.toSeconds());
    }
}
