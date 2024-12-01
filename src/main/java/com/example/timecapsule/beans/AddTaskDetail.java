package com.example.timecapsule.beans;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AddTaskDetail {
    public String name;
    public int taskTypeId;
    public LocalDateTime startDateTime;
    public LocalDateTime endDateTime;
}
