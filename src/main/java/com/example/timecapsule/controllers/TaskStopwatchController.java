package com.example.timecapsule.controllers;


import com.example.timecapsule.beans.AddTaskDetail;
import com.example.timecapsule.beans.Task;
import com.example.timecapsule.beans.UpdateTaskDetail;
import com.example.timecapsule.services.TaskStopwatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping(value = "/tasks/{taskTypeId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getTasks(@PathVariable("taskTypeId") long taskTypeId) {
        return taskStopwatchService.getTasks(taskTypeId);
    }

    // TODO: request body?
    // TODO: reduce size of parameter list
    // TODO: read Spring Boot book on creating mappings
    // TODO: What should the return type be? How does the client know if what is returned is a success?
    // TODO: Create bean for parameters
    @PostMapping(value = "/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTask(@RequestBody AddTaskDetail addTaskDetail) {
        taskStopwatchService.addTask(addTaskDetail.name, addTaskDetail.taskTypeId);
    }

    // TODO: request body?
    // TODO: reduce size of parameter list
    // TODO: read Spring Boot book on creating mappings
    // TODO: What should the return type be? How does the client know if what is returned is a success?
    // TODO: Are there GUIDs in Java? There's UUID
    // TODO: Create bean for parameters
    @PutMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@RequestBody UpdateTaskDetail updateTaskDetail) {
        taskStopwatchService.updateTask(updateTaskDetail.taskId, updateTaskDetail.taskTypeId, updateTaskDetail.name);
    }

    // TODO: What should the return type be? How does the client know if what is returned is a success?
    // TODO: Are there GUIDs in Java?
    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable("id") long id) {
        taskStopwatchService.deleteTask(id);
    }
}
