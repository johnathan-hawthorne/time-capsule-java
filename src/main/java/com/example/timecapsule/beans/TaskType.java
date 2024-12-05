package com.example.timecapsule.beans;

import org.springframework.stereotype.Component;

@Component
public class TaskType {
    public long id;
    public String name;

    public TaskType() {}

    public TaskType(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
