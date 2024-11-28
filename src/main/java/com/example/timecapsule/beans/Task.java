package com.example.timecapsule.beans;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class Task {
    public long id;
    public String name;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public Duration elapsedTime;
    public long timeSlotId;
    // TimeSlot object
    // Tasktype object
    public Long taskTypeId;
}
