package com.example.todo_list_api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTodo(@Valid @RequestBody TodoItem item) {
        todoService.addTodo(item);
        return ResponseEntity.ok("Todo added successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<String> getTodoList() {
        return ResponseEntity.ok(todoService.getTodoList());
    }
}
