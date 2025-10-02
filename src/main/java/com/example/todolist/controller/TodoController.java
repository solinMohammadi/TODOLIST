package com.example.todolist.controller;

import com.example.todolist.dto.TodoDto;
import com.example.todolist.model.TODO;
import com.example.todolist.service.ToDoSERVICE;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {



    private final ToDoSERVICE toDoSERVICE;

    public TodoController(ToDoSERVICE toDoSERVICE) {
        this.toDoSERVICE = toDoSERVICE;
    }

    @PatchMapping
    public ResponseEntity<Integer> save (@RequestBody @Valid TodoDto todoDto){
        TODO todo = new TODO();
        todo.setDescription(todoDto.description());
        todo.setTitle(todoDto.title());
        todo.setCopleted(Boolean.FALSE);
        toDoSERVICE.save(todo);
        return ResponseEntity.ok(todo.getId());
    }
}
