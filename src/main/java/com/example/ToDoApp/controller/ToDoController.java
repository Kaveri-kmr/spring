package com.example.ToDoApp.controller;

import com.example.ToDoApp.model.ToDo;
import com.example.ToDoApp.service.ToDoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService service;

    private static final Logger logger = LoggerFactory.getLogger(ToDoService.class);

    @PostMapping("/todo")
    public ResponseEntity saveTodo(@RequestBody ToDo toDo) {
        service.saveTodo(toDo);
        logger.info("new todo created with title {}", toDo.getTitle());
        return ResponseEntity.ok(CREATED);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ToDo>> getTodo() {
        return new ResponseEntity<List<ToDo>>(service.getTodo(), OK);
    }

    @GetMapping("/welcome")
    public ResponseEntity saywelcome(){
        return ResponseEntity.ok("Hey there!! Welcome to TodoApp");
    }
    @PutMapping("/editTodo")
    public ResponseEntity<Integer> editTodo(@RequestBody ToDo todos) {
        logger.info("editing the todo for id :{}", todos);
        return new ResponseEntity<Integer>(service.updateTodo(todos), OK);
    }

    @DeleteMapping("/deletetodo/{id}")
    public ResponseEntity deleteTodo(@PathVariable Integer id) {
        logger.info("Item deleted for id :{}",id);
        service.deleteTodo(id);
        return ResponseEntity.ok(OK);
    }
}
