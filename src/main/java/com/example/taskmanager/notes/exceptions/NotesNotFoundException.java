package com.example.taskmanager.notes.exceptions;

public class NotesNotFoundException extends IllegalArgumentException{
    public NotesNotFoundException(Long task_Id){
        super("Notes not found for given "+task_Id);
    }
}
