package com.deive.the_awesome_todo.services;

import com.deive.the_awesome_todo.dtos.ToDoDto;
import com.deive.the_awesome_todo.dtos.ToDoDtoForm;
import com.deive.the_awesome_todo.models.ToDoModel;
import com.deive.the_awesome_todo.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDoDto> getToDosList() {
        List<ToDoModel> toDosListModel = this.toDoRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));

        return ToDoDto.getDtoList(toDosListModel);
    }

    public void newToDo(ToDoDtoForm toDoDtoForm) {
        ToDoModel newToDoModel = ToDoDtoForm.generateToDo(toDoDtoForm);

        this.toDoRepository.save(newToDoModel);
    }

    public void markAsCompleted(Long id) {
        Optional<ToDoModel> toDoModelOptional = this.toDoRepository.findById(id);

        if (toDoModelOptional.isPresent()) {
            ToDoModel toDoModel = toDoModelOptional.get();
            toDoModel.setCompletedAt(LocalDateTime.now());
            this.toDoRepository.save(toDoModel);
        }
    }

    public void deleteById(Long id) {
        this.toDoRepository.deleteById(id);
    }
}
