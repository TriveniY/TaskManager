package com.example.taskmanager.notes;

import com.example.taskmanager.tasks.TaskEntity;
import com.example.taskmanager.tasks.TaskRepository;
import com.example.taskmanager.tasks.exceptions.TaskNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    private final NotesRepository notesRepository;

    private final TaskRepository taskRepository;

    public NotesService(NotesRepository notesRepository, TaskRepository taskRepository){
        this.notesRepository = notesRepository;
        this.taskRepository = taskRepository;
    }
    //Get
    public List<NotesEntity> getAllNotesByTaskId(Long task_id){
        TaskEntity task = taskRepository.findById(task_id).orElseThrow(()->new TaskNotFoundException(task_id));
        return task.getNotes();
    }

    public NotesEntity createNotes(Long task_id,NotesEntity notes) {
        TaskEntity task = taskRepository.findById(task_id).orElseThrow(()->new TaskNotFoundException(task_id));
        task.getNotes().add(notes);
        return notesRepository.save(notes);
    }

    public String deleteNotes(Long notes_id) {
        //TaskEntity task = taskRepository.findById(task_id).orElseThrow(()->new TaskNotFoundException(task_id));
        notesRepository.deleteById(notes_id);
        return "notes with id "+notes_id+" deleted.";
    }

}
