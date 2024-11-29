package com.example.timecapsule.services;

import com.example.timecapsule.beans.Task;

import java.time.LocalDate;
import java.util.List;
import java.time.LocalDateTime;

public interface ITaskStopwatchService {
    public List<Task> getTasks(long taskTypeId);

    public void addTask(String name, long taskTypeId);

    public void updateTask(long taskId, long taskTypeId, String name);

    public void deleteTask(long taskId);
}
