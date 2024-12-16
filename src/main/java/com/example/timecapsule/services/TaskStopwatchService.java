package com.example.timecapsule.services;

import com.example.timecapsule.beans.TaskDto;

import java.util.List;
import java.time.LocalDateTime;

public interface TaskStopwatchService {
    List<TaskDto> getTasks(long taskTypeId);

    void addTask(String name, long taskTypeId, LocalDateTime startDateTime, LocalDateTime endDateTime);

    void updateTask(long taskId, long taskTypeId, String name, LocalDateTime startDateTime, LocalDateTime endDateTime);

    void deleteTask(long taskId);
}
