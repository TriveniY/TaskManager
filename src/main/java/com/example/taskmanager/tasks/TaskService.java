package com.example.taskmanager.tasks;

import com.example.taskmanager.tasks.dto.CreateTaskDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    public TaskService(TaskRepository taskRepository,ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }
    public CreateTaskDto createTask(CreateTaskDto taskToCreate){
        TaskEntity newTask = modelMapper.map(taskToCreate, TaskEntity.class);
        taskRepository.save(newTask);
        return modelMapper.map(newTask,CreateTaskDto.class);
    }

    public List<TaskEntity> getTasks(){
        return taskRepository.findAll();
    }
    public TaskEntity getTask(Long taskId){
        return taskRepository.findById(taskId).orElseThrow();
    }

    public TaskEntity updateTask(Long taskId,CreateTaskDto taskToUpdate){
        TaskEntity oldTask = taskRepository.findById(taskId).orElseThrow();
        System.out.println("oldTask-->"+oldTask);
        TaskEntity updatedTask = modelMapper.map(taskToUpdate,TaskEntity.class);
        updatedTask.setId(oldTask.getId());
        System.out.println("oldTask-->"+oldTask);
        updatedTask.setCompleted(true);
        return taskRepository.save(updatedTask);
    }

    public String deleteTask(Long taskId){
        taskRepository.deleteById(taskId);
        return "Task with "+taskId+"deleted.";
    }
}
