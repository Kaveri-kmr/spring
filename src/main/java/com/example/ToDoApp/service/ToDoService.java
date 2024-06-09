package com.example.ToDoApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDoApp.model.ToDo;
import com.example.ToDoApp.repo.IToDoRepository;

@Service
public class ToDoService {

    @Autowired
    IToDoRepository iToDoRepository;

    public void saveTodo(ToDo toDo) {
        iToDoRepository.save(toDo);
    }

    public List<ToDo> getTodo() {
        return iToDoRepository.findAll();
    }

    public Integer updateTodo(ToDo toDos) {
        ToDo saved = iToDoRepository.save(toDos);
        return saved.getId();
    }

    public void deleteTodo(Integer id){
        iToDoRepository.deleteById(Long.valueOf(id));
    }
}
