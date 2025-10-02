package com.example.todolist.service;

import com.example.todolist.model.TODO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ToDoSERVICE {
    void save(TODO todo);
    void changeComplete(TODO todo, boolean complete);
    TODO findById (Integer id);
    Page<TODO> findAll(Pageable pageable);
    void  deletTODOById(Integer id);
}
