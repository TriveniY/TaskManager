package com.example.taskmanager.tasks;

import com.example.taskmanager.tasks.dto.CreateTaskDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
