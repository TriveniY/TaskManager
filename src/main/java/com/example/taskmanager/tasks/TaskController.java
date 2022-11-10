package com.example.taskmanager.tasks;

import com.example.taskmanager.common.ErrorResponseDto;
import com.example.taskmanager.tasks.dto.CreateTaskDto;
import com.example.taskmanager.tasks.exceptions.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private  final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    //Create Task
    @PostMapping("")
    public ResponseEntity<CreateTaskDto> createTask(@RequestBody CreateTaskDto taskToCreate){
        CreateTaskDto savedTask = taskService.createTask(taskToCreate);
        return ResponseEntity.created(URI.create("/tasks/")).body(savedTask);
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

    @ExceptionHandler({TaskNotFoundException.class})
    public ResponseEntity<ErrorResponseDto> handleException(Exception ex){
        ErrorResponseDto error = new ErrorResponseDto();
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
