package com.example.timecapsule.services;

import com.example.timecapsule.beans.Task;

import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;

public interface ITaskStopwatchService {
    public List<Task> getTasks(LocalDateTime selectedDate, long taskTypeId);

    public void addTask(String name, int timerHour, int timerMinute, int timerSecond, LocalDateTime startTime, long taskTypeId);

    public void updateTask(long taskId, String name, LocalDateTime startDate, int startHours, int startMinutes, int startSeconds, String startPeriod,
                           LocalDateTime endDate, int endHours, int endMinutes, int endSeconds, String endPeriod, long taskTypeId);

    public void deleteTask(long taskId);
}
