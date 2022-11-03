package com.example.taskmanager.tasks;

import com.example.taskmanager.notes.NotesEntity;
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
    private Date dueDate;

    @OneToMany
    @JoinColumn(name = "taskId")
    private List<NotesEntity> notes;
}
