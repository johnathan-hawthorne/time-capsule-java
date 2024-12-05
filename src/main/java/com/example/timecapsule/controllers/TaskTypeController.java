package com.example.timecapsule.controllers;

import com.example.timecapsule.beans.TaskType;
import com.example.timecapsule.services.TaskTypeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskTypeController {
    private final TaskTypeServiceImpl taskTypeService;

    public TaskTypeController(TaskTypeServiceImpl taskTypeService) {
        this.taskTypeService = taskTypeService;
    }

    @CrossOrigin
    @GetMapping(value = "/taskTypes")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskType> getTaskTypes() {
        return this.taskTypeService.getTaskTypes();
    }
}
