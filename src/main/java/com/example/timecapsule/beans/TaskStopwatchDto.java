package com.example.timecapsule.beans;

import org.springframework.cglib.core.Local;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

// TODO: Need to figure out how to map this
public class TaskStopwatchDto {
    public Long id;
    public Long taskTypeId;
    public String name;
    public Duration elapsedTime;
    public LocalDateTime startTime;
    public LocalDateTime endTime;

    public TaskStopwatchDto(Long id, Long taskTypeId, String name, Duration elapsedTime, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.taskTypeId = taskTypeId;
        this.name = name;
        this.elapsedTime = elapsedTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TaskStopwatchDto(Task task) {
        id = task.id;
        taskTypeId = task.taskTypeId;
        name = task.name;
        elapsedTime = task.elapsedTime;
        startTime = task.startTime;
        endTime = task.endTime;
    }
}
