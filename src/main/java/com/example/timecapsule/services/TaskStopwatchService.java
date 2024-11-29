package com.example.timecapsule.services;

import com.example.timecapsule.beans.Task;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// What's the difference between @Component and @Service, and when should each be used?
// Both @Component and @Service are bean stereotypes. Not sure when one should be used over the other.
@Service
public class TaskStopwatchService implements ITaskStopwatchService{
    private List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> getTasks(LocalDate selectedDate, long taskTypeId) {
        if (taskTypeId != 1) { // get specific task
            tasks = tasks.stream()
                    .filter(task -> task.taskTypeId == taskTypeId
                            && task.startTime.equals(selectedDate))
                    .collect(Collectors.toList());
        } else { // get all tasks
            tasks = tasks.stream()
                    .filter(task -> task.taskTypeId == null
                            && task.startTime.equals(selectedDate))
                    .collect(Collectors.toList());
        }

        return tasks;
    }

    @Override
    public void addTask(String name, int stopwatchHour, int stopwatchMinute, int stopwatchSecond, LocalDateTime startTime, long taskTypeId) {
        LocalDateTime endTime = LocalDateTime.of(startTime.getYear(),
                startTime.getMonth(), startTime.getDayOfMonth(), stopwatchHour,
                stopwatchMinute, stopwatchSecond);
        Task task = new Task();
        task.id = tasks.size() + 1;
        // map task type here
        task.name = name;
        task.startTime = startTime;
        task.endTime = endTime;
        task.elapsedTime = Duration.between(startTime, endTime);
        tasks.add(task);
    }

    @Override
    public void updateTask(long taskId, String name, LocalDateTime startDate, int startHours, int startMinutes, int startSeconds,
                           String startPeriod, LocalDateTime endDate, int endHours, int endMinutes, int endSeconds, String endPeriod, long taskTypeId) {
        if (startHours == 0) {
            Task task = (Task) tasks.stream().filter(t -> t.id == taskId);
            task.name = name;
            // map task type here
        } else {
            LocalDateTime startTime = LocalDateTime.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(),
                    startHours, startMinutes, startSeconds);
            LocalDateTime endTime = LocalDateTime.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(),
                    endHours, endMinutes, endSeconds);
            Task task = (Task) tasks.stream().filter(t -> t.id == taskId);
            task.name = name;
            // map task type here
            task.startTime = startTime;
            task.endTime = endTime;
            // might need to rewrite elapsed time
            task.elapsedTime = Duration.between(startTime, endTime);
        }
    }

    @Override
    public void deleteTask(long taskId) {
        Task task = (Task) tasks.stream().filter(t -> t.id == taskId);
        tasks.remove(task);
    }
}
