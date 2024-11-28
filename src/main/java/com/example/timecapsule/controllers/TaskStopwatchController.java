package com.example.timecapsule.controllers;


import com.example.timecapsule.beans.Task;
import com.example.timecapsule.services.TaskStopwatchService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

// TODO: need to figure out how the mappings, pathvariables, and request body work
@RestController
@RequestMapping("/tasks")
public class TaskStopwatchController {
    TaskStopwatchService taskStopwatchService;
    public TaskStopwatchController() {
        taskStopwatchService = new TaskStopwatchService();
    }

    // TODO: Are there GUIDs in Java?
    @GetMapping(value = "/{selectedDate}/{taskTypeId}")
    public List<Task> getTasks(@PathVariable("selectedDate") LocalDateTime selectedDate,
                               @PathVariable("taskTypeId") long taskTypeId) {
        return taskStopwatchService.getTasks(selectedDate, taskTypeId);
    }

    // TODO: request body?
    // TODO: reduce size of parameter list
    // TODO: read Spring Boot book on creating mappings
    // TODO: What should the return type be? How does the client know if what is returned is a success?
    @PostMapping
    public void addTask(String name, int timerHour, int timerMinute, int timerSecond, LocalDateTime startTime, long taskTypeId) {
        taskStopwatchService.addTask(name, timerHour, timerMinute, timerSecond, startTime, taskTypeId);
    }

    // TODO: request body?
    // TODO: reduce size of parameter list
    // TODO: read Spring Boot book on creating mappings
    // TODO: What should the return type be? How does the client know if what is returned is a success?
    // TODO: Are there GUIDs in Java?
    @PutMapping
    public void updateTask(long taskId, String name, LocalDateTime startDate, int startHours, int startMinutes, int startSeconds, String startPeriod,
                           LocalDateTime endDate, int endHours, int endMinutes, int endSeconds, String endPeriod, long taskTypeId) {
        taskStopwatchService.updateTask(taskId, name, startDate, startHours, startMinutes, startSeconds, startPeriod,
                endDate, endHours, endMinutes, endSeconds, endPeriod, taskTypeId);
    }

    // TODO: What should the return type be? How does the client know if what is returned is a success?
    // TODO: Are there GUIDs in Java?
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") long id) {
        taskStopwatchService.deleteTask(id);
    }
}
