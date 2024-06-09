package com.example.ToDoApp.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Getter
@Document(collection="todo")
public class ToDo {
	@Id
	private Integer id;

	private String title;
}
