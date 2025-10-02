package com.example.todolist.service;

import com.example.todolist.model.TODO;
import com.example.todolist.myException.NOTFOUNDEXCEPTION;
import com.example.todolist.repository.ToDoREPOSITORY;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ToDoSERVICEImp implements ToDoSERVICE{


    private  final ToDoREPOSITORY toDoREPOSITORY;

    public ToDoSERVICEImp(ToDoREPOSITORY toDoREPOSITORY) {
        this.toDoREPOSITORY = toDoREPOSITORY;
    }

    @Override
    public void save(TODO todo) {
        toDoREPOSITORY.save(todo);

    }

    @Override
    public void changeComplete(TODO todo, boolean complete) {
        todo.setCopleted(complete);
        toDoREPOSITORY.save(todo);

    }

    @Override
    public TODO findById(Integer id) {
        return toDoREPOSITORY.findById(id).orElseThrow(()-> new NOTFOUNDEXCEPTION("todo.not.found"));
    }

    @Override
    public Page<TODO> findAll(Pageable pageable) {
        return toDoREPOSITORY.findAll(pageable);
    }

    @Override
    public void deletTODOById(Integer id)  {
    toDoREPOSITORY.deleteById(id);
    }
}
