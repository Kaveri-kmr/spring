package com.example.ToDoApp.repo;

import com.example.ToDoApp.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IToDoRepository extends MongoRepository<ToDo, Long> {

}
