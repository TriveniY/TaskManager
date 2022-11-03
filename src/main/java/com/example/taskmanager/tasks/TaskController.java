package com.example.taskmanager.tasks;

import com.example.taskmanager.tasks.dto.CreateTaskDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<TaskEntity> getAllTasks(){
        return taskService.getTasks();
    }
    //Get Task for taskId
    @GetMapping("/{taskId}")
    public TaskEntity getTask(@PathVariable Long taskId){
        return taskService.getTask(taskId);
    }
    //Update a task
    @PatchMapping("{taskId}")
    public TaskEntity updateTask(@PathVariable Long taskId, @RequestBody CreateTaskDto taskToUpdate){
        return taskService.updateTask(taskId,taskToUpdate);
    }
    @DeleteMapping("{taskId}")
    public String deleteTask(@PathVariable Long taskId){
        return taskService.deleteTask(taskId);
    }
}
