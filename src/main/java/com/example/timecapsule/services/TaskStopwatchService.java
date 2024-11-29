package com.example.timecapsule.services;

import com.example.timecapsule.beans.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// What's the difference between @Component and @Service, and when should each be used?
// Both @Component and @Service are bean stereotypes. Not sure when one should be used over the other.
@Service
public class TaskStopwatchService implements ITaskStopwatchService{
    private List<Task> tasks;

    public TaskStopwatchService() {
        tasks  = new ArrayList<>();
    }
    @Override
    public List<Task> getTasks(long taskTypeId) {
        return tasks.stream().filter(t -> t.taskTypeId == taskTypeId).collect(Collectors.toList());
    }

    @Override
    public void addTask(String name, long taskTypeId) {
        Task task = new Task();
        task.id = tasks.size() + 1;
        task.name = name;
        task.taskTypeId = taskTypeId;
        tasks.add(task);
    }

    @Override
    public void updateTask(long taskId, long taskTypeId, String name) {
        Task task = tasks.stream().filter(t -> t.id == taskId).findFirst().orElse(null);
        task.name = name;
        task.taskTypeId = taskTypeId;
    }

    @Override
    public void deleteTask(long taskId) {
        tasks.removeIf(t -> t.id == taskId);
    }
}
