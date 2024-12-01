package com.example.timecapsule.services;

import com.example.timecapsule.beans.Task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.time.LocalDateTime;

public interface ITaskStopwatchService {
    public List<Task> getTasks(long taskTypeId);

    public void addTask(String name, long taskTypeId, LocalDateTime startDateTime, LocalDateTime endDateTime);

    public void updateTask(long taskId, long taskTypeId, String name, LocalDateTime startDateTime, LocalDateTime endDateTime);

    public void deleteTask(long taskId);
}
