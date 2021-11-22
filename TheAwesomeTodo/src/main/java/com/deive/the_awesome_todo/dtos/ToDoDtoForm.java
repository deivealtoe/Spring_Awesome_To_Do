package com.deive.the_awesome_todo.dtos;

import com.deive.the_awesome_todo.models.ToDoModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ToDoDtoForm {

    @NotNull
    @NotBlank
    @Size(min = 2, max = 255)
    private String description;

    public ToDoDtoForm() {

    }

    public ToDoDtoForm(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ToDoModel generateToDo(ToDoDtoForm toDoDtoForm) {
        return new ToDoModel(toDoDtoForm.getDescription());
    }

}
