package com.example.timecapsule.controllers;


import com.example.timecapsule.beans.AddTaskDetail;
import com.example.timecapsule.beans.TaskDto;
import com.example.timecapsule.beans.UpdateTaskDetail;
import com.example.timecapsule.services.TaskStopwatchServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@RestController
public class TaskStopwatchController {
    private final TaskStopwatchServiceImpl taskStopwatchService;

    public TaskStopwatchController(TaskStopwatchServiceImpl taskStopwatchService) {
        this.taskStopwatchService = taskStopwatchService;
    }

    @CrossOrigin
    @GetMapping(value = "/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDto> getTasks(long taskTypeId, LocalDate selectedDate) {
        return taskStopwatchService.getTasks(taskTypeId, selectedDate);
    }

    @CrossOrigin
    @PostMapping(value = "/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTask(@RequestBody AddTaskDetail addTaskDetail) {
        taskStopwatchService.addTask(addTaskDetail.name, addTaskDetail.taskTypeId, addTaskDetail.startDateTime,
                addTaskDetail.endDateTime);
    }

    @CrossOrigin
    @PutMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@RequestBody UpdateTaskDetail updateTaskDetail) {
        taskStopwatchService.updateTask(updateTaskDetail.taskId, updateTaskDetail.taskTypeId, updateTaskDetail.name,
                updateTaskDetail.startDateTime, updateTaskDetail.endDateTime);
    }

    @CrossOrigin
    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable("id") long id) {
        taskStopwatchService.deleteTask(id);
    }
}
