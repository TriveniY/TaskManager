package com.example.taskmanager.notes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class NotesController {
    private final NotesService notesService;

    public NotesController(NotesService notesService){
        this.notesService = notesService;
    }
    //Get Notes for taskId
    @GetMapping("/{task_id}/notes")
    public List<NotesEntity> getNotes(@PathVariable Long task_id){
        return notesService.getAllNotesByTaskId(task_id);
    }

    //Create Notes for taskId
    @PostMapping("/{task_id}/notes")
    public NotesEntity createNotes(@PathVariable Long task_id,@RequestBody NotesEntity notes){
        return notesService.createNotes(task_id,notes);
    }
    //Delete Notes for taskId
    @DeleteMapping("/{task_id}/notes/{notes_id}")
    public String deleteNotes(@PathVariable Long notes_id){
        return notesService.deleteNotes(notes_id);
    }

}
