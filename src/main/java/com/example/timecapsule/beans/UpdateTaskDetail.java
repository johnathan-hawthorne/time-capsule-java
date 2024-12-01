package com.example.timecapsule.beans;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UpdateTaskDetail {
    public long taskId;
    public long taskTypeId;
    public String name;
    public LocalDateTime startDateTime;
    public LocalDateTime endDateTime;
}
