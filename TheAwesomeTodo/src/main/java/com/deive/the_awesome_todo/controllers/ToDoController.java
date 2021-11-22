package com.deive.the_awesome_todo.controllers;

import com.deive.the_awesome_todo.dtos.ToDoDto;
import com.deive.the_awesome_todo.dtos.ToDoDtoForm;
import com.deive.the_awesome_todo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/all")
    public String allTodosPage(Model model) {
        List<ToDoDto> toDosList = this.toDoService.getToDosList();

        model.addAttribute("toDosList", toDosList);

        return "all-todo";
    }

    @PostMapping("/new-todo")
    public String newToDo(@Valid ToDoDtoForm toDoDtoForm, Model model) {
        this.toDoService.newToDo(toDoDtoForm);

        return "redirect:/todo/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {
        this.toDoService.deleteById(id);

        return "redirect:/todo/all";
    }

    @GetMapping("/mark-completed/{id}")
    public String markAsCompleted(@PathVariable(name = "id") Long id) {
        this.toDoService.markAsCompleted(id);

        return "redirect:/todo/all";
    }

}
