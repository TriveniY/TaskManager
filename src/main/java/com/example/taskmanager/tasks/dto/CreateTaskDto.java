package com.example.taskmanager.tasks.dto;

import lombok.Data;

@Data
public class CreateTaskDto {
    private String title;
    private String description;
    private String deadline;
}
