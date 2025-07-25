package com.example.todo_list_api;

import jakarta.validation.constraints.NotBlank;

public class TodoItem {
    @NotBlank(message = "Task cannot be empty")
    private final String task;

    private final boolean completed;

    public TodoItem(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
    }

    public String getTask() {
        return task;
    }

    public boolean isCompleted() {
        return completed;
    }
}
