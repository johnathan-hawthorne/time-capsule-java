package com.example.timecapsule.beans;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class Task {
    public long id;
    public long taskTypeId;
    public String name;
    public LocalDateTime startDateTime;
    public LocalDateTime endDateTime;
    public Duration elapsedTime;
}
