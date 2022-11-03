package com.example.taskmanager.tasks.exceptions;

public class TaskNotFoundException extends IllegalArgumentException{

    public TaskNotFoundException(Long taskId){
        super("Task id:"+taskId+"doesn't exist");
    }
}
