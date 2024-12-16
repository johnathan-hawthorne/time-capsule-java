package com.example.timecapsule.services;

import com.example.timecapsule.beans.Task;
import com.example.timecapsule.beans.TaskDto;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskStopwatchServiceImpl implements TaskStopwatchService {
    private List<Task> tasks;

    public TaskStopwatchServiceImpl() {
        tasks  = new ArrayList<>();
    }
    @Override
    public List<TaskDto> getTasks(long taskTypeId) {
        return tasks.stream().filter(t -> t.taskTypeId == taskTypeId).map(TaskDto::new).collect(Collectors.toList());
    }

    @Override
    public void addTask(String name, long taskTypeId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Task task = new Task();
        task.id = tasks.size() + 1;
        task.name = name;
        task.taskTypeId = taskTypeId;
        // TODO: temporary fix for time zone issue
        task.startDateTime = startDateTime.minusHours(6);
        task.endDateTime = endDateTime.minusHours(6);
        task.elapsedTime = Duration.between(task.startDateTime, task.endDateTime);
        tasks.add(task);
    }

    @Override
    public void updateTask(long taskId, long taskTypeId, String name, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Task task = tasks.stream().filter(t -> t.id == taskId).findFirst().orElse(null);
        task.name = name;
        task.taskTypeId = taskTypeId;
        // TODO: temporary fix for time zone issue
        task.startDateTime = startDateTime.minusHours(6);
        task.endDateTime = endDateTime.minusHours(6);
        task.elapsedTime = Duration.between(task.startDateTime, task.endDateTime);
    }

    @Override
    public void deleteTask(long taskId) {
        tasks.removeIf(t -> t.id == taskId);
    }
}
