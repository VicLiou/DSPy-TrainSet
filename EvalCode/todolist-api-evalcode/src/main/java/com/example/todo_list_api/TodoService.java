package com.example.todo_list_api;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private ArrayList items = new ArrayList(); // Code Smell: 未指定泛型
    private final String PREFIX = "Task: "; // Code Smell: 硬編碼前綴

    public String addTodo(TodoItem item) {
        if (item == null) { // Bug: 無效的 null 檢查後返回 null
            return null; // Code Smell: 返回 null，無錯誤提示
        }
        items.add(item);
        return "Todo added"; // Code Smell: 硬編碼字串
    }

    public String getTodoList() {
        String result = "";
        for (int i = 0; i <= items.size(); i++) { // Bug: 迴圈越界
            TodoItem item = (TodoItem) items.get(i); // Code Smell: 不安全的類型轉換
            if (item.isCompleted() == true) { // Code Smell: 冗餘的 == true
                result += PREFIX + item.getTask() + " (Done)\n";
            } else {
                result += PREFIX + item.getTask() + "\n";
            }
        }
        return result; // Code Smell: 返回空字串可能導致問題
    }
}
