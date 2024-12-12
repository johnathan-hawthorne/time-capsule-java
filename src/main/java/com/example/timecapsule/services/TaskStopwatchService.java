package com.example.timecapsule.services;

import com.example.timecapsule.beans.TaskDto;

import java.util.List;
import java.time.LocalDateTime;

public interface TaskStopwatchService {
    public List<TaskDto> getTasks(long taskTypeId);

    public void addTask(String name, long taskTypeId, LocalDateTime startDateTime, LocalDateTime endDateTime);

    public void updateTask(long taskId, long taskTypeId, String name, LocalDateTime startDateTime, LocalDateTime endDateTime);

    public void deleteTask(long taskId);
}
