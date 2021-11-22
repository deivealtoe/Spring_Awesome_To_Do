package com.deive.the_awesome_todo.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "todos")
public class ToDoModel {

    @Id
    @SequenceGenerator(name = "sequence_todo", sequenceName = "sequence_todo", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_todo")
    private Long id;
    @NotNull
    private String description;
    @NotNull
    LocalDateTime createdAt = LocalDateTime.now();
    LocalDateTime completedAt;

    public ToDoModel() {

    }

    public ToDoModel(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

}
