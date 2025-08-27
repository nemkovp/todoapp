package com.springpro.todoapp.controller;

import com.springpro.todoapp.model.TodoItem;
import com.springpro.todoapp.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TodoController{

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public String index(Model model){
        List<TodoItem> allTodos = todoRepository.findAll();
        model.addAttribute("allTodos",allTodos);
        model.addAttribute("newTodo", new TodoItem());

        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute TodoItem todoItem){
        todoRepository.save(todoItem);

        return "redirect:/";
    }

}
