package com.example.taskmanager.tasks;

import com.example.taskmanager.notes.NotesEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name="tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/mm/yyyy")
    private Date deadline;

    @OneToMany
    @JoinColumn(name = "taskId")
    private List<NotesEntity> notes;
}

