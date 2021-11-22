package com.deive.the_awesome_todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String redirectToToDo() {
        return "redirect:/todo/all";
    }

}
