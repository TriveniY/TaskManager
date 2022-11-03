package com.example.taskmanager.tasks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    //Create Task
    @PostMapping("")
    public void createTask(){

    }
    //Get All Tasks
    @GetMapping("")
    public void getAllTasks(){

    }
    //Get Task for taskId
    @GetMapping("/{id}")
    public void getTask(){

    }
    //Update a task
    public void UpdateTask(){

    }
}
