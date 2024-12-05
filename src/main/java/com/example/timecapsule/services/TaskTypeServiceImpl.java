package com.example.timecapsule.services;

import com.example.timecapsule.beans.TaskType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskTypeServiceImpl implements TaskTypeService {
    private List<TaskType> taskTypes;

    public TaskTypeServiceImpl() {
        taskTypes = new ArrayList<>();
        taskTypes.add(new TaskType(1, "Test Task Type"));
    }

    @Override
    public List<TaskType> getTaskTypes() {
        return taskTypes;
    }
}
