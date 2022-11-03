package com.example.taskmanager.tasks;

import com.example.taskmanager.tasks.dto.CreateTaskDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    //Create Task
    @PostMapping("")
    public CreateTaskDto createTask(@RequestBody CreateTaskDto taskToCreate){
        return taskService.createTask(taskToCreate);
    }
    //Get All Tasks
    @GetMapping("")
    public String getAllTasks(){
        return "this is Get request";
    }
    //Get Task for taskId
    @GetMapping("/{taskId}")
    public void getTask(@PathVariable Long taskId){

    }
    //Update a task
    @PatchMapping("{taskId}")
    public void UpdateTask(@PathVariable Long taskId){

    }
}
