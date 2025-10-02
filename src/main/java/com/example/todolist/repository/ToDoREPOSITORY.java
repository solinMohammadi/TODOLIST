package com.example.todolist.repository;

import com.example.todolist.model.TODO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoREPOSITORY extends JpaRepository<TODO,Integer> {
}
