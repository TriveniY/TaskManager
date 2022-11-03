package com.example.taskmanager.tasks.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CreateTaskDto {
    private String title;
    private String description;
    private Date dueDate;
}
