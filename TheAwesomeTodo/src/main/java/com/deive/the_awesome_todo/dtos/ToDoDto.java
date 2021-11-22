package com.deive.the_awesome_todo.dtos;

import com.deive.the_awesome_todo.models.ToDoModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoDto {

    private Long id;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    public ToDoDto (ToDoModel toDoModel) {
        this.id = toDoModel.getId();
        this.description = toDoModel.getDescription();
        this.createdAt = toDoModel.getCreatedAt();
        this.completedAt = toDoModel.getCompletedAt();
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

    public static List<ToDoDto> getDtoList(List<ToDoModel> toDosListModel) {
        List<ToDoDto> toDosDtoList = new ArrayList<>();

        toDosListModel.forEach(toDoModel -> {
            toDosDtoList.add(new ToDoDto(toDoModel));
        });

        return toDosDtoList;
    }

}
