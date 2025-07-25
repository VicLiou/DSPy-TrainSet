package com.example.todo_list_api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
    private static final String TASK_PREFIX = "Task: "; // 定義為常數，易於配置
    private final List<TodoItem> items = new ArrayList<>();

    public void addTodo(@Valid TodoItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Todo item cannot be null");
        }
        items.add(item);
    }

    public String getTodoList() {
        if (items.isEmpty()) {
            return "No todos available";
        }
        StringBuilder result = new StringBuilder();
        for (TodoItem item : items) {
            result.append(TASK_PREFIX)
                  .append(item.getTask())
                  .append(item.isCompleted() ? " (Done)" : "")
                  .append("\n");
        }
        return result.toString();
    }
}
