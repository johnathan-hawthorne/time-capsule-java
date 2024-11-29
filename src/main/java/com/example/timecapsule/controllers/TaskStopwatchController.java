package com.example.timecapsule.controllers;


import com.example.timecapsule.beans.Task;
import com.example.timecapsule.services.TaskStopwatchService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

// TODO: need to figure out how the mappings, pathvariables, and request body work
@RestController
public class TaskStopwatchController {
    private final TaskStopwatchService taskStopwatchService;

    public TaskStopwatchController(TaskStopwatchService taskStopwatchService) {
        this.taskStopwatchService = taskStopwatchService;
    }

    // TODO: Are there GUIDs in Java?
    @GetMapping(value = "/tasks/{selectedDate}/{taskTypeId}")
    public List<Task> getTasks(@PathVariable("selectedDate") String selectedDate,
                               @PathVariable("taskTypeId") long taskTypeId) {
        return taskStopwatchService.getTasks(LocalDate.parse(selectedDate, DateTimeFormatter.BASIC_ISO_DATE), taskTypeId);
    }

    // TODO: request body?
    // TODO: reduce size of parameter list
    // TODO: read Spring Boot book on creating mappings
    // TODO: What should the return type be? How does the client know if what is returned is a success?
    // TODO: Create bean for parameters
    @PostMapping(value = "/tasks")
    public HttpStatus addTask(String name, int timerHour, int timerMinute, int timerSecond, LocalDateTime startTime, long taskTypeId) {
        taskStopwatchService.addTask(name, timerHour, timerMinute, timerSecond, startTime, taskTypeId);

        return HttpStatus.CREATED;
    }

    // TODO: request body?
    // TODO: reduce size of parameter list
    // TODO: read Spring Boot book on creating mappings
    // TODO: What should the return type be? How does the client know if what is returned is a success?
    // TODO: Are there GUIDs in Java? There's UUID
    // TODO: Create bean for parameters
    @PutMapping("/tasks")
    public HttpStatus updateTask(long taskId, String name, LocalDateTime startDate, int startHours, int startMinutes, int startSeconds, String startPeriod,
                           LocalDateTime endDate, int endHours, int endMinutes, int endSeconds, String endPeriod, long taskTypeId) {
        taskStopwatchService.updateTask(taskId, name, startDate, startHours, startMinutes, startSeconds, startPeriod,
                endDate, endHours, endMinutes, endSeconds, endPeriod, taskTypeId);

        return HttpStatus.OK;
    }

    // TODO: What should the return type be? How does the client know if what is returned is a success?
    // TODO: Are there GUIDs in Java?
    @DeleteMapping("/{id}")
    public HttpStatus deleteTask(@PathVariable("id") long id) {
        taskStopwatchService.deleteTask(id);

        return HttpStatus.OK;
    }
}
