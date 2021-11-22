package com.deive.the_awesome_todo.repositories;

import com.deive.the_awesome_todo.models.ToDoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoModel, Long> {



}
