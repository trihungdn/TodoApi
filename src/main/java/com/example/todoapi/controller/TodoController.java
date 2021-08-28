package com.example.todoapi.controller;

import com.example.todoapi.model.request.TodoRequest;
import com.example.todoapi.model.response.TodoResponse;
import com.example.todoapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/search/{title}/{page}")
    public List<TodoResponse> searchTodo(@PathVariable(name = "title") String title, @PathVariable(name = "page") int page) {
        return todoService.searchTodo(title, page);
    }

    @PostMapping("")
    public ResponseEntity<String> addTodo(@RequestBody TodoRequest todoRequest) {
        todoService.saveTodo(todoRequest);
        return new ResponseEntity<>("Add Todo successful !", HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<String> updateTodo(@RequestBody TodoRequest todoRequest) {
        todoService.saveTodo(todoRequest);
        return new ResponseEntity<>("Update Todo successful !", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable(value = "id") Integer id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>("Delete Todo successful !", HttpStatus.OK);
    }
}
