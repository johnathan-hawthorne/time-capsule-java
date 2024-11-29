package com.example.timecapsule.beans;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class Task {
    public long id;
    public Long taskTypeId;
    public String name;

}
